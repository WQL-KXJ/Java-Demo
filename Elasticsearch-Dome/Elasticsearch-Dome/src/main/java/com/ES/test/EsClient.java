package com.ES.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;

import java.io.IOException;
import java.net.InetAddress;

/*
 * @Author WQL-KXJ
 * @ProjectName Elasticsearch-Dome
 * @PackageName com.ES.test
 * @Date 2022/8/31 11:40
 * @Version 1.0
 */
public class EsClient {
    public static void main(String[] args) throws IOException {

        RestClient restClient = RestClient.builder(
                new HttpHost("localhost",9200,"http")
        ).build();


        restClient.

        restClient.close();
    }
}
