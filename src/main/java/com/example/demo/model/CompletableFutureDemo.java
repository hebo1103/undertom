package com.example.demo.model;

/**
 * @author HB
 * @data 2020/9/16 8:12
 * @Description: 控制层
 */
public class CompletableFutureDemo {

    public static String name(String ij) {
        try {
            System.out.println("获取姓名开始");
            Thread.sleep(9000);
            System.out.println("获取姓名结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ZZZ";
    }

    public static Integer age() {
        try {
            System.out.println("获取年龄开始");
            Thread.sleep(6000);
            System.out.println("获取年龄结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 18;
    }

    public static String sex() {
        try {
            System.out.println("获取性别开始");
            Thread.sleep(3000);
            System.out.println("获取性别结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "男";
    }
}
