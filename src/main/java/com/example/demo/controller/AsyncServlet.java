package com.example.demo.controller;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HB
 * @data 2020/9/16 11:02
 * @Description: 控制层
 */
//@WebServlet(urlPatterns = "/asyncServlet", asyncSupported = true)
public class AsyncServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        Util.println("开始执行servlet");
        //开启异步上下文
        AsyncContext asyncContext = request.startAsync();
        //异步上下文设置回调函数（监听器）
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                ServletResponse response1 = asyncEvent.getSuppliedResponse();
                response1.setContentType("text/html;charset=UTF-8");
                response1.getWriter().println("complete回调函数返回输出");
                Util.println("complete回调函数完成");
            }

            @Override
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {

            }

            @Override
            public void onError(AsyncEvent asyncEvent) throws IOException {

            }

            @Override
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {

            }
        });
        //开启新的工作线程，释放servlet处理请求线程，工作完后回调异步上下文的监听器
        new Thread(() -> {
            try {
                ServletResponse response1 = asyncContext.getResponse();
                response1.setContentType("text/html;charset=UTF-8");
                response1.getWriter().print("异步工作线程返回输出");
                //出发回调函数onComplete()
                Util.println("工作线程完成");
                asyncContext.complete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        Util.println("释放servlet线程");
    }
}
