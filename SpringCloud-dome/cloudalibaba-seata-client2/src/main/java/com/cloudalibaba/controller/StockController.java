package com.cloudalibaba.controller;

import com.cloudalibaba.entity.stockpojo;
import com.cloudalibaba.service.StockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @Autowired
    StockServiceImpl stockService;

    @GetMapping("/StockConoller/{c}")
    public void StockConoller(@PathVariable("c") int c){

        boolean b = stockService.setStock(c);
    }


}
