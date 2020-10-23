package com.example.demo.designpatterns.apiImpl.strategy2;

import com.example.demo.common.interfaces.OrderHandlerType;
import com.example.demo.designpatterns.api.strategy2.OrderHandler;
import com.example.demo.model.OrderStrategy;

/**
 * @author HB
 * @data 2020/10/14 13:53
 * @Description: 控制层
 */
@OrderHandlerType(source = "mobile")
public class MobileOrderHandler implements OrderHandler {
    @Override
    public String handle(OrderStrategy order) {
        System.out.println("这个是移动策略");
        return "这个是移动策略";
    }
}
