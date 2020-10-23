package com.example.demo.controller;

import com.example.demo.common.aop.MyAnnotation;
import com.example.demo.designpatterns.apiImpl.strategy2.OrderService;
import com.example.demo.designpatterns.apiImpl.strategy2.OrderService2;
import com.example.demo.model.OrderStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author HB
 * @data 2020/9/16 11:27
 * @Description: 控制层
 */
@Slf4j
@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderService2 orderService2;

    @GetMapping("/hello")
    public Flux<String> hello() throws InterruptedException {
        Thread.sleep(10000);
        return Flux.just("Welcome to reactive world ~");
    }

    @GetMapping("/hello_strategy")
    @MyAnnotation(a = "123")
    public String helloStrategy(String str) throws InterruptedException {
        OrderStrategy order = new OrderStrategy();
        order.setSource(str);
        order.setPayMethod("");
        orderService2.orderService(order);
        return orderService.orderService(order);
    }
}
