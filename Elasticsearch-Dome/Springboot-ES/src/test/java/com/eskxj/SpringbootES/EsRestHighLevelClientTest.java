package com.eskxj.SpringbootES;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/*
 * @Author WQL-KXJ
 * @ProjectName Springboot-ES
 * @PackageName com.eskxj.SpringbootES
 * @Date 2022/9/4 12:23
 * @Version 1.0
 */
@SpringBootTest
public class EsRestHighLevelClientTest {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Test
    void Createindex() throws IOException {
        //创建索引对象，传入参数索引名
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("index-wql");
        /**创建映射
         *1，参数1：映射内容
         *2，参数2：映射内容的格式
         * **/
        createIndexRequest.mapping("{\n" +
                "    \"properties\": {\n" +
                "      \"title\":{\n" +
                "        \"type\":\"text\"\n" +
                "      },\n" +
                "      \"price\":{\n" +
                "        \"type\": \"double\"\n" +
                "      },\n" +
                "      \"create_at\":{\n" +
                "        \"type\":\"date\"\n" +
                "      }\n" +
                "    }\n" +
                "  }", XContentType.JSON);
        //参数1：索引对象  参数2：请求的配置对象
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse.isAcknowledged());
        restHighLevelClient.close();
    }

    //删除索引
    @Test
    void DeleteIndex() throws IOException {

        //索引删除对象
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("pro");

        AcknowledgedResponse delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);

        System.out.print(delete.isAcknowledged());

    }

    //创建文档
    @Test
    void indexDocment() throws IOException {
        //参数：索引名称
        IndexRequest indexRequest = new IndexRequest("index-wql");
        indexRequest.id("2")//指定文档id
                    .source("{\n" + //指定文档数据
                            "  \"title\":\"英雄联盟手机壳\",\n" +
                            "  \"price\":20,\n" +
                            "  \"create_at\":\"2022-09-01\"\n" +
                            "}",XContentType.JSON);
        //创建文档
        IndexResponse index = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.print(index.status());
    }

    //更新文档
    @Test
    void updateDocment() throws IOException {

        //更新文档对象 参1：索引 参2：文档id
        UpdateRequest updateRequest = new UpdateRequest("index-wql","1");
        //更新的文档内容
        updateRequest.doc("{\n" +
                "  \"title\":\"我TM是个废物\",\n" +
                "  \"price\":\"0.1\",\n" +
                "  \"create_at\":\"2022-09-01\"\n" +
                "}",XContentType.JSON);

        UpdateResponse update = restHighLevelClient.update(updateRequest,RequestOptions.DEFAULT);
        System.out.print(update.status());
    }

    //删除文档
    @Test
    void deleteDocment() throws IOException {

        //删除文档对象
        DeleteRequest deleteRequest = new DeleteRequest("index-wql","1000");

        DeleteResponse delete = restHighLevelClient.delete(deleteRequest,RequestOptions.DEFAULT);

        System.out.print(delete.status());
    }

    //基于id查询文档
    @Test
    void getDocment() throws IOException {
        //查询对象
        GetRequest getRequest = new GetRequest("index-wql","1");

        GetResponse documentFields = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);

        System.out.print(documentFields.getSourceAsString()+"\n"+documentFields.getId());
    }


}
