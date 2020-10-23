package com.example.demo.common;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author HB
 * @data 2020/9/16 13:51
 * @Description: 控制层
 */
@Component
public class HelloRouter {

    @Bean
    public RouterFunction<ServerResponse> hello(HelloHandler helloHandler) {
//        return RouterFunctions.route(RequestPredicates.GET("/hello")
//                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), helloHandler::sayHello);
        return null;
    }
}
