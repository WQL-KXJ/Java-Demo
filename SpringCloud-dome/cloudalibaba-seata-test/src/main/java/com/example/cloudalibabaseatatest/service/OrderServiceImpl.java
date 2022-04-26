package com.example.cloudalibabaseatatest.service;


import com.example.cloudalibabaseatatest.dao.orderDao;
import com.example.cloudalibabaseatatest.entity.orderpojo;
import com.example.cloudalibabaseatatest.feignservice.orderfeign;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    orderDao orderDao;

    @Autowired
    orderfeign orderfeign;

    @Override
    @GlobalTransactional
    public boolean setOrder(orderpojo orderpojo) {

        boolean b = orderDao.insert_order(orderpojo);
        orderfeign.dw(orderpojo.getProductId());
        int a= 10/0;
        return b;
    }
}
