package com.example.demo.controller;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author HB
 * @data 2020/9/16 10:56
 * @Description: SwingFrame响应式
 */
public class SwingFrame {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setBounds(200,200,400,400);

        jFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Util.println("鼠标点击事件");
            }
        });

        jFrame.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                Util.println("焦点事件");
            }
        });
    }
}
