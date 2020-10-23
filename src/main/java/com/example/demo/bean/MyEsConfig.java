package com.example.demo.bean;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * @author HB
 * @data 2020/10/22 15:46
 * @Description: 控制层
 */
@Configuration
public class MyEsConfig {

    @Value("${spring.elasticsearch.rest.uris}")
    private String clientInfo;

    @Bean("myEsTemplate1")
    public MyEsTemplate myEsTemplate() {
        Pattern p = compile("(\\d+\\.\\d+\\.\\d+\\.\\d+)\\:(\\d+)");
        Matcher m = p.matcher(clientInfo);
        String http = "";
        String ip = "";
        String port = "";
        while (m.find()) {
            http = m.group(0);
            ip = m.group(1);
            port = m.group(2);
            System.out.println("ip:" + m.group(1));
            System.out.println("port:" + m.group(2));
        }
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(ip, Integer.valueOf(port), "http")));
        MyEsTemplate myEsTemplate = new MyEsTemplate(client);
        return myEsTemplate;
    }
}
