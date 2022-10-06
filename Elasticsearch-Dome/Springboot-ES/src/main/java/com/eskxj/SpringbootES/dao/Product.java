package com.eskxj.SpringbootES.dao;

import lombok.Data;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/*
 * @Author WQL-KXJ
 * @ProjectName Springboot-ES
 * @PackageName com.eskxj.SpringbootES.dao
 * @Date 2022/9/4 9:35
 * @Version 1.0
 */
@Data
@Document(indexName = "products_es",createIndex = true)
public class Product {

    @Id
    private Integer id;

    @Field(type = FieldType.Keyword)
    private String title;

    @Field(type = FieldType.Double)
    private Double price;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String description;
}
