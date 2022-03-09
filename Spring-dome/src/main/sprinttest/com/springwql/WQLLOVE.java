package com.springwql;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class WQLLOVE {
    String a;
    public  WQLLOVE(){

    }
    public  WQLLOVE(String a){
        this.a=a;
    }
    public void wql(){
        System.out.print(a);
    }

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "WQLLOVE{" +
                "a='" + a + '\'' +
                '}';
    }
}
