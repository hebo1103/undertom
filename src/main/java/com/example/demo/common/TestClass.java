package com.example.demo.common;

import com.example.demo.designpatterns.api.abstractfactory.FruitA;
import com.example.demo.designpatterns.api.abstractfactory.FruitFactoryA;
import com.example.demo.designpatterns.api.factorymethod.Fruit;
import com.example.demo.designpatterns.api.factorymethod.FruitFactory;
import com.example.demo.designpatterns.api.observer.Observer;
import com.example.demo.designpatterns.apiImpl.abstractfactory.ChinaFactoryA;
import com.example.demo.designpatterns.apiImpl.abstractfactory.EnglandFactoryA;
import com.example.demo.designpatterns.apiImpl.factorymethod.AppleFactory;
import com.example.demo.designpatterns.apiImpl.factorymethod.BananaFactory;
import com.example.demo.designpatterns.apiImpl.observer.User;
import com.example.demo.designpatterns.apiImpl.observer.WechatServer;
import com.example.demo.model.TestModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author HB
 * @data 2020/10/13 14:18
 * @Description: 控制层
 */
public class TestClass {

    /**
     * 测试观察者模式
     */
    public void observer() {
        WechatServer server = new WechatServer();

        Observer userZhang = new User("ZhangSan");
        Observer userLi = new User("LiSi");
        Observer userWang = new User("WangWu");

        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        server.setInfomation("PHP是世界上最好用的语言！");

        System.out.println("----------------------------------------------");
        server.removeObserver(userZhang);
        server.setInfomation("JAVA是世界上最好用的语言！");
    }

    public void java8() {
        TestModel testModel1 = new TestModel();
        testModel1.setId("2");
        testModel1.setName("123");
        TestModel testModel2 = new TestModel();
        testModel2.setId("1");
        testModel2.setName("123");
        List<TestModel> list = new ArrayList<>();
        list.add(testModel1);
        list.add(testModel2);
        Map<String, String> skuNumMap = list.stream().collect(Collectors.toMap(TestModel::getId, dto -> dto.getName(), (v1, v2) -> v1));
        System.out.println("");
    }

    /**
     * 工厂方法模式
     */
    public void factoryMethod() {
        //AppleFactory
        FruitFactory ff = new AppleFactory();

        Fruit apple = ff.getFruit();
        apple.get();


        FruitFactory ff2 = new BananaFactory();
        Fruit banana = ff2.getFruit();
        banana.get();

    }

    /**
     * 抽象工厂模式
     */
    public void abstractFactory() {
        FruitFactoryA chinaFactory = new ChinaFactoryA();
        //通过中国工厂生产中国苹果实例
        FruitA apple = chinaFactory.getApple();
        apple.get();
        //通过中国工厂生产中国香蕉实例
//        FruitA banana = chinaFactory.getBanana();
//        banana.get();
        //创建英国工厂
        FruitFactoryA englandFactory = new EnglandFactoryA();
        //通过英国工厂生产英国苹果实例
        FruitA apple1 = englandFactory.getApple();
        apple1.get();
        //通过英国工厂生产英国香蕉实例
//        FruitA banana2 = englandFactory.getBanana();
//        banana2.get();
    }
}
