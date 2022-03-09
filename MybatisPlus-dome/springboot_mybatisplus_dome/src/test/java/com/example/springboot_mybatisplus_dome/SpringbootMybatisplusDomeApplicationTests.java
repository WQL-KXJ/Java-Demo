package com.example.springboot_mybatisplus_dome;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot_mybatisplus_dome.dao.mapper.mybatisplus_mapper;
import com.example.springboot_mybatisplus_dome.dao.pojo.mybatisplus_pojo;
import com.example.springboot_mybatisplus_dome.myenum.myenum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class SpringbootMybatisplusDomeApplicationTests {

	@Autowired
	mybatisplus_mapper mapper;

	@Test
	void contextLoads() {

		mybatisplus_pojo selectById = mapper.selectById(1L);

		System.out.println(selectById);
	}

	@Test
	void insert(){
		mybatisplus_pojo mybatisplusPojo = new mybatisplus_pojo();
		mybatisplusPojo.setAge(20);
		mybatisplusPojo.setName("lalala");
		mybatisplusPojo.setSex(myenum.NAN);
		int insert = mapper.insert(mybatisplusPojo);
		if(insert!=0){
			System.out.println("插入数据成功！:"+mybatisplusPojo.getId());
		}else {
			System.out.println("插入数据失败！");
		}
	}

	@Test
	void updateid(){
		mybatisplus_pojo mybatisplusPojo = new mybatisplus_pojo();
		mybatisplusPojo.setId(1);
		mybatisplusPojo.setName("UpdataID");

		mybatisplusPojo.setAge(10);
		int i = mapper.updateById(mybatisplusPojo);
		if(i!=0){
			System.out.println("更新数据成功！");
		}else {
			System.out.println("更新数据失败！");
		}

	}

	@Test
	void updatewrapper(){
		mybatisplus_pojo mybatisplusPojo = new mybatisplus_pojo();
		mybatisplusPojo.setName("UpdataWrapper");
		mybatisplusPojo.setSex(myenum.NAN);
		mybatisplusPojo.setAge(100);
//		QueryWrapper<mybatisplus_pojo> queryWrapper = new QueryWrapper();
//		queryWrapper.eq("id",3);

		UpdateWrapper<mybatisplus_pojo> updateWrapper = new UpdateWrapper<>();
		//set方法是UpdateWrapper区别于QueryWrapper的一个特点，它可以指定要更新的值，最后接条件
		updateWrapper.set("sex",0).set("name","UpdateWrapper").eq("id",2);
		//因为updateWrapper设置了要更新的值，所有这个实体类设置为null
		int update = mapper.update(null,null);
		System.out.println(update);
	}

	@Test
	void deleteid(){

		int i = mapper.deleteById(2);
		System.out.println(i);
	}

	@Test
	void deletemap(){

		Map<String,Object> map = new HashMap<>();
		map.put("name","FQ");
		map.put("age","100");
		int i = mapper.deleteByMap(map);
		System.out.println(i);
	}

	@Test
	void deletewrapper(){
		//写法一
		QueryWrapper<mybatisplus_pojo> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("name","FQ").eq("age","100");

		//写法二：传入条件对象
		mybatisplus_pojo m = new mybatisplus_pojo();
		m.setName("FQ");//name为FQ
		m.setAge(100);//age为100
		QueryWrapper<mybatisplus_pojo> queryWrapper1 =new QueryWrapper<>(m);//将对象作为条件传入，这种写法可以避免你的字段写错

 		int i = mapper.delete(queryWrapper);
		System.out.println(i);
	}
	@Test
	void deletedibatch(){
		//连续删除ID为2，3，4的数据
		List<Integer> integers = Arrays.asList(2, 3, 4);
		mapper.deleteBatchIds(integers);
	}

	@Test
	void selectibatch(){

		List<Integer> list =Arrays.asList(3,2);

		List<mybatisplus_pojo> list1 = mapper.selectBatchIds(list);

		for(mybatisplus_pojo m :list1){

			System.out.println(m);
		}
	}

	@Test
	void selectone(){

		QueryWrapper<mybatisplus_pojo> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("name","da").eq("age","21");
		queryWrapper.select("name","age");
		mybatisplus_pojo mybatisplusPojo = mapper.selectOne(queryWrapper);

		System.out.println(mybatisplusPojo);
	}

	@Test
	void selectlist() {
		QueryWrapper<mybatisplus_pojo> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("sex",myenum.NAN);

		List<mybatisplus_pojo> mybatisplus_pojos = mapper.selectList(queryWrapper);
		for(mybatisplus_pojo m :mybatisplus_pojos){

			System.out.println(m);
		}
	}

	@Test
	void selectcount(){
		QueryWrapper<mybatisplus_pojo> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("name","da");


		Integer integer = mapper.selectCount(queryWrapper);
		System.out.println(integer);

	}
	@Test
	void selectpage() {
		//设置分页对象Page
		Page<mybatisplus_pojo> pojoPage = new Page<>(1,1);
		//设置条件查询
		QueryWrapper<mybatisplus_pojo> queryWrapper = new QueryWrapper<>();
		queryWrapper.like("name","da");
		//分页查询并获取分页查询对象
		Page<mybatisplus_pojo> pojoPage1 = mapper.selectPage(pojoPage, queryWrapper);

		System.out.println("查询的总页数："+pojoPage1.getPages());
		System.out.println("查询的总条数："+pojoPage1.getTotal());
		System.out.println("当前页数："+pojoPage1.getCurrent());
		System.out.println("当前size："+pojoPage1.getSize());
		//通过分页查询对象获取当前页的数据
		List<mybatisplus_pojo> records = pojoPage1.getRecords();
		for(mybatisplus_pojo m :records){
			System.out.println(m);
		}


	}

}
