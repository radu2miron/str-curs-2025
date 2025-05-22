package edu.tucn.str.lecture5.ex3_future_api_gui;

import java.math.BigDecimal;

/**
 * @author Radu Miron
 * @version 1
 */
public record CoinModel(Integer rank, String name, Quotes quotes) {
}

record Quotes(USD USD) {
}

record USD(Double price, BigDecimal market_cap) {}