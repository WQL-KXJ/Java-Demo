package com.cloudalibaba.service;

import com.cloudalibaba.dao.stockDao;
import com.cloudalibaba.entity.stockpojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    stockDao stockDao;

    @Override
    public boolean setStock(int productid) {

        boolean b = stockDao.update_stock(productid);

        return b;
    }
}
