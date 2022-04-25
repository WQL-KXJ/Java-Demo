package com.example.cloudalibabaseatatest.feignservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface orderfeign {

    @GetMapping("/StockConoller/{c}")
    public void dw(@PathVariable("c") int c);

}
