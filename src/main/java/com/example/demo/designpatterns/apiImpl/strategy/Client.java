package com.example.demo.designpatterns.apiImpl.strategy;

import com.example.demo.designpatterns.api.strategy.Strategy;

/**
 * @author HB
 * @data 2020/9/22 16:04
 * @Description: 控制层
 */
public class Client {

    public static void main(String[] args) {
        //策略模式
        Strategy strategy1 = new StrategyImplOne();
        StrategyContext strategyContext1 = new StrategyContext(strategy1);
        String string1 = strategyContext1.execute();
        System.out.println("第一个策略：" + string1);
        Strategy strategy2 = new StrategyImplTwo();
        StrategyContext strategyContext2 = new StrategyContext(strategy2);
        String string2 = strategyContext2.execute();
        System.out.println("第二个策略：" + string2);
    }
}
