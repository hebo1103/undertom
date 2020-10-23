package com.example.demo.common;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author HB
 * @data 2020/9/16 13:35
 * @Description: 控制层
 */
@Component
public class HelloHandler {

    public Mono<ServerResponse> sayHello(ServerRequest req) {
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(req.queryParam("name").get()));
    }
}
