package com.example.demo.designpatterns.apiImpl.abstractfactory;

import com.example.demo.designpatterns.api.abstractfactory.AppleA;

/**
 * @author HB
 * @data 2020/10/13 14:31
 * @Description: 控制层
 */
public class ChinaAppleA extends AppleA {
    @Override
    public void get() {
        System.out.println("中国的苹果...");
    }
}
