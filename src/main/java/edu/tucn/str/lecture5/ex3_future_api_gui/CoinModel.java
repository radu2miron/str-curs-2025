package edu.tucn.str.lecture5.ex3_future_api_gui;

/**
 * @author Radu Miron
 * @version 1
 */
public record CoinModel(Data data) {
}

record Data(String rank, String name, String marketCapUsd, String priceUsd) {
}