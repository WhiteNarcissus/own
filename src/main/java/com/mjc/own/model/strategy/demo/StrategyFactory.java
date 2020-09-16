package com.mjc.own.model.strategy.demo;

public interface StrategyFactory {
    Strategy createStrategy(String type);
}
