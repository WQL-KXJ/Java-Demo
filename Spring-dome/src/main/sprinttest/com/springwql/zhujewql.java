package com.springwql;

import org.springframework.stereotype.Component;

@Component(value = "q") //value相当于xml配置文件中的ID,如果没有value默认是类名首字母小写
public class zhujewql {
    /*
     针对bean管理的注解：在class上面使用
     1，@Component:通用的
     2，@Service：用在server，业务逻辑层上
     3，@Controller：用在web层上
     4，@Repository：用在dao层上
     这四种注解是作用都是一样的，只是针对的场景
          */
     String wql="wql love fq";

     public  void f(){
         System.out.print(wql);
     }



}
