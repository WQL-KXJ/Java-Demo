package com.dao;

import com.bean.jdbctemplatetest;

import java.util.List;

public interface select_dao_in {

    public int query_int();

    public jdbctemplatetest queue_bean(int id);

    public List<jdbctemplatetest> queue_list();
}
