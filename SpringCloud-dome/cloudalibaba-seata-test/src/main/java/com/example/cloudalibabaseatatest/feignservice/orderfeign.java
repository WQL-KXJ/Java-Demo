package com.example.cloudalibabaseatatest.feignservice;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "seata-stock")
public interface orderfeign {

    @GetMapping("/StockConoller/{c}")
    public void dw(@PathVariable("c") int c);

}
