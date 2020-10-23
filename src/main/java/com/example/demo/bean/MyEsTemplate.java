package com.example.demo.bean;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**
 * @author HB
 * @data 2020/10/22 15:39
 * @Description: 控制层
 */
public class MyEsTemplate {

    RestHighLevelClient client = null;

    MyEsTemplate(RestHighLevelClient client){
        this.client = client;
    }

    public SearchResponse query(SearchSourceBuilder searchSourceBuilder, String index) {
        SearchRequest searchRequest = new SearchRequest(index);
        searchRequest.source(searchSourceBuilder);
        try {
            return client.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
