package com.example.demo.designpatterns.apiImpl.strategy2;

import com.example.demo.common.interfaces.OrderHandlerType;
import com.example.demo.designpatterns.api.strategy2.OrderHandler;
import com.example.demo.model.OrderStrategy;

/**
 * @author HB
 * @data 2020/10/14 13:55
 * @Description: 控制层
 */
@OrderHandlerType(source = "pc")
public class PCOrderHandler implements OrderHandler {
    @Override
    public String handle(OrderStrategy order) {
        System.out.println("这是一个PC上的订单策略");
        return "这是一个PC上的订单策略";
    }
}
