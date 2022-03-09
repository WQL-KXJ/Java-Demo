package com.springwql;

import java.util.Arrays;
import java.util.Map;

public class WQLcollection {
    String[] a;
    Map<Integer,String> Arr;
    public void setA(String[] a) {
        this.a = a;
    }

    public void setArr( Map<Integer,String> arr) {
        Arr = arr;
    }

    public WQLcollection(String[] a) {
        this.a = a;
    }

    public  Map<Integer,String> getArr() {
        return Arr;
    }

    public  WQLcollection(){

    }
    public  void show(){
        for(int b=0;b<a.length;b++) {
            System.out.print(a[b]+"\t");
        }
    }

    public  void show2(){
        for (Integer a:Arr.keySet()){
        System.out.print(a+"\t"+Arr.get(a)+"\n");
        }



    }
}
