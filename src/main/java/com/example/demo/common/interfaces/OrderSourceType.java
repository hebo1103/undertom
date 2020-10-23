package com.example.demo.common.interfaces;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author HB
 * @data 2020/9/28 8:17
 * @Description: 控制层
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OrderSourceType {

//    @AliasFor("name")
    String source();
}
