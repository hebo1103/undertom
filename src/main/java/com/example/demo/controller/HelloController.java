package com.example.demo.controller;

import com.example.demo.common.aop.MyAnnotation;
import com.example.demo.designpatterns.apiImpl.strategy2.OrderService;
import com.example.demo.designpatterns.apiImpl.strategy2.OrderService2;
import com.example.demo.model.OrderStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

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


    @RequestMapping("/test/mono/{who}")
    @ResponseBody
    public Mono<String> testMono(@PathVariable String who) {
        return Mono.just(who)
                .map(w -> "Hello " + w + "!");
    }

    public Flux<String> alphabet5(char from) {
        return Flux.range((int) from, 5)
                .map(i -> "" + (char) i.intValue());
    }

    public Mono<String> withDelay(String value, int delaySeconds) {
        return Mono.just(value)
                .delaySubscription(Duration.ofSeconds(delaySeconds));
    }
}
