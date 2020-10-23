package com.example.demo.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;

/**
 * @author HB
 * @data 2020/9/22 16:20
 * @Description: 控制层
 */
@Component
public class InitProject implements ApplicationRunner, CommandLineRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner启动成功===============");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner启动成功===============");
        ClassPathResource classPathResource = new ClassPathResource("test.txt");
        InputStream inputStream1 = classPathResource.getInputStream();
        String str1 = readTxt(inputStream1);
        System.out.println("str1:" + str1);
        InputStream inputStream2 = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.txt");
        String str2 = readTxt(inputStream2);
        System.out.println("str2:" + str2);
        InputStream inputStream3 = this.getClass().getResourceAsStream("/test.txt");
        String str3 = readTxt(inputStream3);
        System.out.println("str3:" + str3);
        File file = ResourceUtils.getFile("classpath:test.txt");
        InputStream inputStream4 = new FileInputStream(file);
        String str4 = readTxt(inputStream4);
        System.out.println("str4:" + str4);
    }

    public String readTxt(InputStream inputStream) throws IOException {
        String s = "";
        InputStreamReader in = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader br = new BufferedReader(in);
        StringBuffer content = new StringBuffer();
        while ((s = br.readLine()) != null) {
            content = content.append(s);
        }
        return content.toString();
    }


}
