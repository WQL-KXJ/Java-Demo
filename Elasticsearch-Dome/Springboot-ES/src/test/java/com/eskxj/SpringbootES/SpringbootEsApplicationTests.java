package com.eskxj.SpringbootES;

import com.eskxj.SpringbootES.dao.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.StringQuery;

import java.util.Map;

@SpringBootTest
class SpringbootEsApplicationTests {

	@Autowired
	ElasticsearchOperations elasticsearchOperations;

	//1,保存数据
	@Test
	void contextLoads() {
		Product product = new Product();
		product.setId(1);
		product.setTitle("光影笔墨");
		product.setPrice(123.12);
		product.setDescription("留声机的回忆");
		elasticsearchOperations.save(product);
	}

	//2,按照id查询文档
	@Test
	void selectId() {
		Product product = elasticsearchOperations.get("1", Product.class);
		System.out.println(product.getTitle()+"\n"+product.getDescription());
	}

	//3，按照id删除
	@Test
	void deleteId() {
		String delete = elasticsearchOperations.delete("1", Product.class);
		System.out.println(delete);
	}

	//4，查询所有文档
	@Test
	void selectAll() throws JsonProcessingException {
		SearchHits<Product> search = elasticsearchOperations.search(Query.findAll(), Product.class);
		System.out.println(search.getTotalHits());//总条数
		for (SearchHit<Product> pro:search){
			System.out.println(new ObjectMapper().writeValueAsString(pro.getContent()));
		}
	}

}
