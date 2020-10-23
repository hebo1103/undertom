package com.example.demo.common.interfaces;

/**
 * @author HB
 * @data 2020/10/22 16:52
 * @Description: 控制层
 */
public interface TestFunctionInterface<R, T> {

    public T getInfo(R r);

    public default R getValue(Class<?> t) {
        return null;
    }

}
