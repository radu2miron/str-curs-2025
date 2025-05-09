package edu.tucn.str.lecture5.ex5virtualthreads.ex3find_carrier_trheads_num;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * @author Radu Miron
 * @version 1
 */
public class Ex1CarrierThreadsNum {
    public static void main(String[] args) {
        System.out.printf("number of cores: %d \nnumber of carrier threads: %d",
                findNumberOfProcessorCores(),
                findNumberOfCarrierThreads());
    }

    private static int findNumberOfProcessorCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    private static int findNumberOfCarrierThreads() {
        Pattern pattern = Pattern.compile(".*@ForkJoinPool-1-worker-(\\d+)");
        List<String> vtNames = new CopyOnWriteArrayList<>();

        IntStream.range(0, 20_000)
                .mapToObj(i -> Thread.startVirtualThread(() -> vtNames.add(Thread.currentThread().toString())))
                .toList().stream()
                .forEach(t -> {
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                    }
                });

        return vtNames.stream()
                .map(vtName -> {
                    Matcher matcher = pattern.matcher(vtName);
                    matcher.find();
                    return matcher.group(1);
                })
                .mapToInt(s -> Integer.parseInt(s))
                .max()
                .orElseThrow(() -> new RuntimeException("It can't be!"));
    }
}
