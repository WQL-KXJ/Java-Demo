package com.example.springboot_mybatisplus_dome.dao.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.springboot_mybatisplus_dome.dao.pojo.mybatisplus_pojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface mybatisplus_mapper extends BaseMapper<mybatisplus_pojo> {

    @Override
    mybatisplus_pojo selectById(Serializable id);

    @Override
    int insert(mybatisplus_pojo entity);

    @Override
    int updateById(@Param("et") mybatisplus_pojo entity);

    @Override
    int update(@Param("et") mybatisplus_pojo entity, @Param("ew")Wrapper<mybatisplus_pojo> updateWrapper);

    @Override
    int deleteById(Serializable id);

    @Override
    int deleteByMap(Map<String, Object> columnMap);

    @Override
    int delete(@Param("ew")Wrapper<mybatisplus_pojo> queryWrapper);

    @Override
    int deleteBatchIds(Collection<? extends Serializable> idList);

    @Override
    List<mybatisplus_pojo> selectBatchIds(@Param("coll")Collection<? extends Serializable> idList);

    @Override
    mybatisplus_pojo selectOne(@Param("ew")Wrapper<mybatisplus_pojo> queryWrapper);

    @Override
    List<mybatisplus_pojo> selectList(@Param("ew")Wrapper<mybatisplus_pojo> queryWrapper);

    @Override
    Integer selectCount(@Param("ew")Wrapper<mybatisplus_pojo> queryWrapper);

    @Override
    <E extends IPage<mybatisplus_pojo>> E selectPage(E page, @Param("ew")Wrapper<mybatisplus_pojo> queryWrapper);
}
