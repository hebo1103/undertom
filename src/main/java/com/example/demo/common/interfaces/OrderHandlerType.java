package com.example.demo.common.interfaces;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @author HB
 * @data 2020/10/14 13:52
 * @Description: 控制层
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Service
public @interface OrderHandlerType {

    String source() default "";

    String method() default "";
}
