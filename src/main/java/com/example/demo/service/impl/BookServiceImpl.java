package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.MyEsTemplate;
import com.example.demo.model.BookBean;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.TopHits;
import org.elasticsearch.search.aggregations.metrics.TopHitsAggregationBuilder;
import org.elasticsearch.search.aggregations.pipeline.BucketSortPipelineAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author HB
 * @data 2020/9/24 13:56
 * @Description: 控制层
 */
@Service("blogService")
public class BookServiceImpl implements BookService {
    @Autowired
    @Qualifier("bookRepository")
    private BookRepository bookRepository;

    @Autowired
    RestHighLevelClient operations;

    @Autowired(required = true)
    MyEsTemplate myEsTemplate2;

    @Override
    public Optional<BookBean> findById(String id) {
        //CrudRepository中的方法
        return bookRepository.findById(id);
    }

    @Override
    public BookBean save(BookBean blog) {
        return bookRepository.save(blog);
    }

    @Override
    public void delete(BookBean blog) {
        bookRepository.delete(blog);
    }

    @Override
    public Optional<BookBean> findOne(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<BookBean> findAll() {
        return (List<BookBean>) bookRepository.findAll();
    }

    @Override
    public Page<BookBean> findByAuthor(String author, PageRequest pageRequest) {
        return bookRepository.findByAuthor(author, pageRequest);
    }

    @Override
    public Page<BookBean> findByTitle(String title, PageRequest pageRequest) {
        return bookRepository.findByTitle(title, pageRequest);
    }

    @Override
    public List<BookBean> findByPage() throws IOException {
        //构造查询器
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//查询条件查询所有
        QueryBuilder queryBuilders = QueryBuilders.matchAllQuery();
// 需要返回字段的集合
        String[] param = {"title"};
// 对需要返回的数据包括哪些,不包括哪些,重复的只返回1条
        TopHitsAggregationBuilder top1 = AggregationBuilders.topHits("top").fetchSource(param, Strings.EMPTY_ARRAY).size(1);
// 通过pid聚合并且聚合后返回10条数据,注意这里的size(这里代表聚合查询出多少条数据,注意这里的size要比最下面分页的size要大,因为是对聚合后的数据分页,如果不写的话默认是10)
        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("agg").field("title").subAggregation(top1).size(10);
// 聚合分页
        termsAggregationBuilder.subAggregation(new BucketSortPipelineAggregationBuilder("bucket_field", null).from(0).size(10));
// 这里的.from(0).size(1) 表示最外层hits返回的数据
        searchSourceBuilder.query(queryBuilders).aggregation(termsAggregationBuilder).from(0).size(1);
//解析返回的数据
        SearchResponse response = getSearchResponse(searchSourceBuilder);
        System.out.println("=============" + JSON.toJSONString(response));
        Terms agg = response.getAggregations().get("agg");
        for (Terms.Bucket bucket : agg.getBuckets()) {
            TopHits top = bucket.getAggregations().get("top");
            for (SearchHit searchHit : top.getHits()) {
                System.out.println(searchHit.getSourceAsMap());
            }
        }
        return null;
    }

    // 执行查询并且返回response
    private SearchResponse getSearchResponse(SearchSourceBuilder searchSourceBuilder) throws IOException {
        SearchResponse response = myEsTemplate2.query(searchSourceBuilder, "book");
        return response;
    }
}
