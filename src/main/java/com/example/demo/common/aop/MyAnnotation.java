package com.example.demo.common.aop;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author HB
 * @data 2020/10/9 10:32
 * @Description: 控制层
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {

    /**
     * 何种场景下的通用日志打印
     *
     * @return
     */
    @AliasFor("a")
    String module() default "";

    /**
     * 何种场景下的通用日志打印
     *
     * @return
     */
    @AliasFor("module")
    String a() default "";
}
