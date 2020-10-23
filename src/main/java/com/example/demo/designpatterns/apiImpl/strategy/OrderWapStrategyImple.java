package com.example.demo.designpatterns.apiImpl.strategy;

import com.example.demo.common.interfaces.OrderSourceType;
import com.example.demo.designpatterns.api.strategy.OrderStrategy;
import com.example.demo.model.Order;

/**
 * @author HB
 * @data 2020/9/28 8:23
 * @Description: 控制层
 */
public class OrderWapStrategyImple implements OrderStrategy {

    @Override
    @OrderSourceType(source = "wap")
    public void getOrderType(Order order) {

    }
}
