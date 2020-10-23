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
 * @data 2020/10/14 14:10
 * @Description: 控制层
 */
@Service
public class OrderService {

    private Map<String, OrderHandler> orderHandleMap;


    @Autowired()
    public void setOrderHandleMap(List<OrderHandler> orderHandlers) {
        // 注入各种类型的订单处理类
        orderHandleMap = orderHandlers.stream().collect(
                Collectors.toMap(orderHandler -> AnnotationUtils.findAnnotation(orderHandler.getClass(), OrderHandlerType.class).source(),
                        v -> v, (v1, v2) -> v1));
        System.out.println("将数据加入到集合中");
    }

    public String orderService(OrderStrategy order) {
        // ...一些前置处理

        // 通过订单来源确定对应的handler
        OrderHandler orderHandler = orderHandleMap.get(order.getSource());
        return orderHandler.handle(order);

        // ...一些后置处理
    }
}
