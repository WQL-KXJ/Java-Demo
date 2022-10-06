package com.eskxj.SpringbootES.config;

import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.client.reactive.ReactiveRestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/*
 * @Author WQL-KXJ
 * @ProjectName Springboot-ES
 * @PackageName com.eskxj.SpringbootES.config
 * @Date 2022/9/4 0:21
 * @Version 1.0
 */
@Configuration
public class ESRestClientConfig extends AbstractElasticsearchConfiguration {

    @Value("${Elasticsearch.Host}")
    String host;

    public RestHighLevelClient elasticsearchClient() {

        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(host)
                .build();
        return RestClients.create(clientConfiguration).rest();

    }
}
