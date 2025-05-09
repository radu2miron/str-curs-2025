package edu.tucn.str.lecture5.ex4_completablefuture_api_gui;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.concurrent.CompletableFuture;

/**
 * @author Radu Miron
 * @version 1
 */
public class WeatherApiUtils {
    private static final String BASE_URL = "https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&current=temperature_2m";

    private static TemperatureResult getTemperature(City city) throws Exception {
        URI target = new URI(String.format(BASE_URL, city.getLat(), city.getLng()));
        HttpRequest request = HttpRequest.newBuilder(target).GET().build();
        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            Gson gson = new Gson();
            String tempDataJson = response.body();
            TemperatureModel temperatureModel = gson.fromJson(tempDataJson, TemperatureModel.class);
            return new TemperatureResult(city, temperatureModel.current().temperature_2m(), temperatureModel.current_units().temperature_2m());
        } else {
            throw new RuntimeException("Getting temperature for " + city.getDisplayName() + "; " +
                    "Invalid response code: " + response.statusCode());
        }
    }

    public static List<TemperatureResult> getTemperatures() {
        List<TemperatureResult> temperatures = new ArrayList<>();
        List<CompletableFuture<TemperatureResult>> temperatureFutures = new ArrayList<>();

        // perform the REST API calls asynchronously
        Arrays.asList(City.values()).stream()
                .forEach(city -> temperatureFutures.add(CompletableFuture.supplyAsync(() -> {
                    try {
                        return getTemperature(city);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                })));

        // combine the results of all calls
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(temperatureFutures.toArray(new CompletableFuture[0]));
        allFutures.join();

        // get the results from futures
        allFutures.thenRun(() -> temperatureFutures.forEach(tf -> temperatures.add(tf.join())));

        // sort by rank
        return temperatures.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(temp -> temp.city().getDisplayName()))
                .toList();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getTemperature(City.SATU_MARE));
        System.out.println(getTemperature(City.CLUJ_NAPOCA));
        System.out.println(getTemperature(City.CHISINAU));
    }
}
