package com.example.demo.designpatterns.api.strategy;

import com.example.demo.model.Order;

/**
 * @author HB
 * @data 2020/9/28 8:21
 * @Description: 控制层
 */
public interface OrderStrategy {

    public void getOrderType(Order order);
}
