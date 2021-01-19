package com.example.demo.functional;

import com.example.demo.common.interfaces.TestFunctionInterface;

import java.util.concurrent.Callable;

/**
 * @author HB
 * @data 2020/10/22 17:08
 * @Description: 控制层
 */
public class TestFunctional {

    public Integer testFunctional1() {
        TestFunctionInterface<String, Integer> stringIntegerTestFunctionInterface = a -> Integer.valueOf(a + 1);
//        Integer in = test1(() -> stringIntegerTestFunctionInterface.getInfo("23"));
        TestClass<Integer> testClass = new TestClass();
        testClass.o = 100;
        Integer in = test1(testClass::call);
        System.out.println("stringIntegerTestFunctionInterface:" + in);
        return in;
    }

    public <T> T test1(Callable<T> valueLoader) {
        try {
            return valueLoader.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    class TestClass<M> {
        M o;

        M call() {
            Boolean f = Boolean.TRUE;
            return o;
        }
    }
}
