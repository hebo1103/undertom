package com.example.demo.designpatterns.api.strategy2;

import com.example.demo.model.OrderStrategy;

/**
 * @author HB
 * @data 2020/10/14 13:42
 * @Description: 控制层
 */
public interface OrderHandler {

    String handle(OrderStrategy order);
}
