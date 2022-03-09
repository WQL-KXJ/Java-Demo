package com.service;

import com.dao.deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class tx_ann_service {

    @Autowired
    deal da;

    public void accounts(String inname, String outname, int money){
        da.in(inname,money);
        System.out.println(1/0);
        da.out(outname,money);
    }

}
