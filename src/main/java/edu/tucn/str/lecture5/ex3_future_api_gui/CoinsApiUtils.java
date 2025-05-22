package edu.tucn.str.lecture5.ex3_future_api_gui;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Radu Miron
 * @version 1
 */
public class CoinsApiUtils {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(5);
    private static final String BASE_URL = "https://api.coinpaprika.com/v1/tickers/";
    private static final List<String> COINS = List.of("btc-bitcoin", "eth-ethereum", "usdt-tether", "xrp-xrp", "bnb-binance-coin");

    private static CoinModel getCoin(String coinName) throws Exception {
        URI target = new URI(BASE_URL + coinName);
        HttpRequest request = HttpRequest.newBuilder(target).GET().build();
        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            Gson gson = new Gson();
            String coinDataJson = response.body();
            return gson.fromJson(coinDataJson, CoinModel.class);
        } else {
            throw new RuntimeException("Getting coin " + coinName + "; " +
                    "Invalid response code: " + response.statusCode());
        }
    }

    public static List<CoinModel> getCoins() {
        List<CoinModel> coins = new ArrayList<>();
        List<Future<CoinModel>> futureCoins = new ArrayList<>();

        COINS.forEach(coin ->
                // DO ASYNCHRONOUS CALLS!
                futureCoins.add(EXECUTOR_SERVICE.submit(() -> getCoin(coin))));

        // await for all responses
        futureCoins.forEach(futureCoin -> {
            try {
                coins.add(futureCoin.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // sort by rank
        coins.sort(Comparator.comparing(CoinModel::rank));

        return coins;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getCoin("xrp"));
        System.out.println(getCoin("solana"));
        System.out.println(getCoin("binance-coin"));
    }
}
