package com.service;

import com.dao.deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


public class tx_service {

    private deal da;
    public tx_service(deal de) {
    this.da=de;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void accounts(String inname, String outname, int money){
      da.in(inname,money);
      System.out.println(1/0);
      da.out(outname,money);
  }


}
