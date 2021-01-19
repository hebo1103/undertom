package com.example.demo.controller;

import com.example.demo.model.Order;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

/**
 * @author HB
 * @data 2020/9/16 10:56
 * @Description: SwingFrame响应式
 */
public class SwingFrame {
    public static void main(String[] args) {
        Order order = new Order();
        Optional<String> value = Optional.ofNullable(order).map(Order::getSource);
        String a = value.orElse("1654565464");
        Boolean bl = value.isPresent();
        Util.println("value==============={},{},{}" + a + bl);
        LocalDateTime now = LocalDateTime.now();
        LocalDate localDate = now.toLocalDate();
        LocalTime localTime = now.toLocalTime();
        Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        LocalDateTime localDateTime = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dtf2.format(localDateTime);
        Util.println("now当前时间：" + now);
        Util.println("localDate当前时间" + localDate);
        Util.println("localTime当前时间" + localTime);
        Util.println("date当前时间" + date);
        Util.println("localDateTime当前时间" + localDateTime);
        Util.println("format当前时间" + format);
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setBounds(200, 200, 400, 400);

        jFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
                Util.println("鼠标点击事件");
            }
        });

        jFrame.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
//                super.focusGained(e);
                Util.println("焦点事件");
            }
        });
    }
}
