package com.example.demo;

import com.example.demo.functional.TestFunctional;
import com.example.demo.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

/**
 * Demo class
 *
 * @author keriezhang
 * @date 2016/10/31
 */
@SpringBootApplication(scanBasePackages = {"com.example.*"})
@ServletComponentScan
@Slf4j
public class UndertowApplication {

    public static void main(String[] args) {
//        ApplicationContext applicationContext = SpringApplication.run(UndertowApplication.class, args);
        SpringApplication springApplication = new SpringApplication(UndertowApplication.class);
        ApplicationContext applicationContext = springApplication.run(args);
        log.info("服务启动成功===============================");
        log.info("服务启动成功===============================");
        log.info("服务启动成功===============================");
        log.info("服务启动成功===============================");
//        HelloController helloController = applicationContext.getBean(HelloController.class);
//
//        TestClass testClass = new TestClass();
        // testClass.java8();
        //观察者模式，发布订阅模式，发布者和订阅者有一定关系，嵌套比较深
        // testClass.observer();
        //测试工厂方法模式
        // testClass.factoryMethod();
        //抽象工厂模式
//        testClass.abstractFactory();
//        String reg = "^[1-1000]";
//        String i = "1";
//        Boolean fla = i.matches(reg);
        //测试java8的函数式编程
        TestFunctional testFunctional = new TestFunctional();
        testFunctional.testFunctional1();
        //测试方法引用
        Person[] pArr = new Person[]{
                new Person("003", LocalDate.of(2016, 9, 1)),
                new Person("001", LocalDate.of(2016, 2, 1)),
                new Person("002", LocalDate.of(2016, 3, 1)),
                new Person("004", LocalDate.of(2016, 12, 1))};
        Arrays.sort(pArr, (a, b) -> Person.compareByAge(a, b));
        Arrays.sort(pArr, Person::compareByAge);
    }
}
