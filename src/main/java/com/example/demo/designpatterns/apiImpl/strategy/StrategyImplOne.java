package com.example.demo.designpatterns.apiImpl.strategy;

import com.example.demo.designpatterns.api.strategy.Strategy;

/**
 * @author HB
 * @data 2020/9/22 15:56
 * @Description: 控制层
 */
public class StrategyImplOne implements Strategy {
    @Override
    public String run() {
        return "这个是第一个策略模式";
    }
}
