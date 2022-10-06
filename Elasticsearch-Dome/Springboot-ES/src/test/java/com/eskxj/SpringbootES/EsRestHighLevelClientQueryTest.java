package com.eskxj.SpringbootES;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedDoubleTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.ParsedAvg;
import org.elasticsearch.search.aggregations.metrics.ParsedSum;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/*
 * @Author WQL-KXJ
 * @ProjectName Springboot-ES
 * @PackageName com.eskxj.SpringbootES
 * @Date 2022/9/5 0:10
 * @Version 1.0
 */
@SpringBootTest
public class EsRestHighLevelClientQueryTest {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    //查询所有
    @Test
    void QueryAll() throws IOException {
        //创建搜索对象 参数：指定索引
        SearchRequest searchRequest = new SearchRequest("index-wql");
        //创建查询条件对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());//查询所有
        searchRequest.source(searchSourceBuilder);

        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        //获取结果
        SearchHit[] hits = search.getHits().getHits();
        for (SearchHit h:hits){
            System.out.println(h.getId()+"\t"+h.getSourceAsString());
        }
    }

    //关键字查询
    @Test
    void QueryTerm() throws IOException {

        SearchRequest searchRequest = new SearchRequest("index-wql");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery("title","废"));
        searchRequest.source(searchSourceBuilder);

        SearchResponse search = restHighLevelClient.search(searchRequest,RequestOptions.DEFAULT);
        SearchHit[] hits = search.getHits().getHits();
        for (SearchHit h:hits){
            System.out.println(h.getId()+"\t"+h.getSourceAsString());
        }
    }

    //范围查询
    @Test
    void QueryRange() throws IOException {

        SearchRequest searchRequest = new SearchRequest("index-wql");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.rangeQuery("price").lt(50));
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = restHighLevelClient.search(searchRequest,RequestOptions.DEFAULT);
        SearchHit[] hits = search.getHits().getHits();
        for (SearchHit h:hits){
            System.out.println(h.getId()+"\t"+h.getSourceAsString());
        }
    }

    //分页排序查询
    @Test
    void QueryPageSort() throws IOException {

        SearchRequest searchRequest = new SearchRequest("index-wql");

        //创建一个高亮器
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        /**
         * field()：需要高亮的字段
         * requireFieldMatch()：关闭字段匹配
         * preTags():自定义高亮标签前缀
         * postTags()：标签后缀
         */
        highlightBuilder.requireFieldMatch(false).field("title").preTags("<span style='color:red'>").postTags("</span>");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery("title","废"))
                            .from(0)//起始位置
                            .size(10)//每页条数
                            .sort("price", SortOrder.DESC)//排序字段
                            .fetchSource(new String[]{},new String[]{"create_at"})//数组1：结果需要包含的字段 数组2：结果需要排除的字段
                            .highlighter(highlightBuilder);//指定高亮
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = restHighLevelClient.search(searchRequest,RequestOptions.DEFAULT);
        SearchHit[] hits = search.getHits().getHits();
        for (SearchHit h:hits){
            System.out.println(h.getId()+"\t"+h.getSourceAsString());

            Map<String, HighlightField> highlightFields = h.getHighlightFields();
            if(highlightFields.containsKey("title")){
                System.out.print("title高亮结果"+highlightFields.get("title").fragments()[0]);
            }
        }
    }

    //范围查询
    @Test
    void QueryFilter() throws IOException {

        SearchRequest searchRequest = new SearchRequest("index-wql");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery())
                          //指定过滤条件
                           .postFilter(QueryBuilders.termQuery("title","物"));
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = restHighLevelClient.search(searchRequest,RequestOptions.DEFAULT);
        SearchHit[] hits = search.getHits().getHits();
        for (SearchHit h:hits){
            System.out.println(h.getId()+"\t"+h.getSourceAsString());
        }
    }

    //聚合查询
    @Test
    void aggQuery() throws IOException {
        SearchRequest searchRequest = new SearchRequest("index-wql");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery())
                            .aggregation(AggregationBuilders.terms("price_group").field("price"))//指定分组
                            .size(0);
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = restHighLevelClient.search(searchRequest,RequestOptions.DEFAULT);

        //处理查询结果
        Aggregations aggregations = search.getAggregations();
        ParsedDoubleTerms price_group = aggregations.get("price_group");
        List<? extends Terms.Bucket> buckets = price_group.getBuckets();
        for (Terms.Bucket bucket:buckets){
            System.out.println(bucket.getKey()+"\t"+bucket.getDocCount());
        }

    }

    //求和
    @Test
    void SumQuery() throws IOException {
        SearchRequest searchRequest = new SearchRequest("index-wql");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery())
                .aggregation(AggregationBuilders.sum("price_sum").field("price"))//指定分组
                .size(0);
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = restHighLevelClient.search(searchRequest,RequestOptions.DEFAULT);
        //获取
        ParsedSum price_sum = search.getAggregations().get("price_sum");
        System.out.println(price_sum.getValue());
    }

    //求和
    @Test
    void AvgQuery() throws IOException {
        SearchRequest searchRequest = new SearchRequest("index-wql");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery())
                .aggregation(AggregationBuilders.avg("price_avg").field("price"))//指定分组
                .size(0);
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = restHighLevelClient.search(searchRequest,RequestOptions.DEFAULT);
        //获取
        ParsedAvg price_avg = search.getAggregations().get("price_avg");
        System.out.println(price_avg.getValue());
    }
}

