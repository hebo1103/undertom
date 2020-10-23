package com.example.demo.designpatterns.apiImpl.strategy2;

import com.example.demo.common.interfaces.OrderHandlerType;
import com.example.demo.designpatterns.api.strategy2.OrderHandler;
import com.example.demo.model.OrderStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author HB
 * @data 2020/10/14 16:13
 * @Description: 控制层
 */
@Service
public class OrderService2 {

    private Map<OrderHandlerType, OrderHandler> orderHandleMap;

    @Autowired
    public void setOrderHandleMap(List<OrderHandler> orderHandlers) {
        // 注入各种类型的订单处理类
        orderHandleMap = orderHandlers.stream().collect(
                Collectors.toMap(orderHandler -> AnnotationUtils.findAnnotation(orderHandler.getClass(), OrderHandlerType.class),
                        v -> v, (v1, v2) -> v1));
    }

    public void orderService(OrderStrategy order) {
        // ...一些前置处理

        // 通过订单来源确以及支付方式获取对应的handler
        OrderHandlerType orderHandlerType = new OrderHandlerTypeImpl(order.getSource(), order.getPayMethod());
        OrderHandler orderHandler = orderHandleMap.get(orderHandlerType);
        orderHandler.handle(order);

        // ...一些后置处理
    }
}
