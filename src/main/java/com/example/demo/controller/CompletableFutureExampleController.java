package com.example.demo.controller;

import com.example.demo.model.CompletableFutureDemo;
import com.example.demo.model.Man;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

/**
 * @author HB
 * @data 2020/9/15 16:00
 * @Description: 多线程测试类
 */
@Slf4j
@RestController
@RequestMapping("test")
public class CompletableFutureExampleController {

    @GetMapping("/testApi.do")
    public void testApi() {
        log.info("测试多线程返回参数开始================");
        long startTime = System.currentTimeMillis();
        //1.分页获取子订单表的数据(此处订单表与主体表进行关联查询)
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("bodyAndContract-thread-%d").build();
        ExecutorService threadPool = new ThreadPoolExecutor(10, 20, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(20),
                namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        Man man = new Man();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(CompletableFutureDemo::name, threadPool);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(CompletableFutureDemo::age, threadPool);
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(CompletableFutureDemo::sex, threadPool);

        CompletableFuture<Void> completableFuture1 = future1.thenAccept(man::setName);
        CompletableFuture<Void> completableFuture2 = future2.thenAccept(man::setAge);
        CompletableFuture<Void> completableFuture3 = future3.thenAccept(man::setSex);

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(completableFuture1, completableFuture2, completableFuture3);
        completableFuture.join();
        System.out.println(man);
        threadPool.shutdown();
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) / 1000 + "s");
        log.info("测试多线程返回参数结束");
    }
}
