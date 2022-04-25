package com.example.cloudalibabaseatatest.service;

import com.cloudalibaba.dao.orderDao;
import com.cloudalibaba.entity.orderpojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    orderDao orderDao;

    @Override
    public boolean setOrder(orderpojo orderpojo) {

        boolean b = orderDao.insert_order(orderpojo);


        return b;
    }
}
