package com.example.demo.designpatterns.apiImpl.strategy;

import com.example.demo.designpatterns.api.strategy.Strategy;

/**
 * @author HB
 * @data 2020/9/22 16:02
 * @Description: 控制层
 */
public class StrategyContext {

    Strategy strategy;

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    String execute() {
        return strategy.run();
    }
}
