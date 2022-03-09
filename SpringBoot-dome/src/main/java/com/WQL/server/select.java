package com.WQL.server;

import com.WQL.mapper.accountmapper;
import com.WQL.pojo.jdbccrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class select {

    @Autowired
    accountmapper a;

    public jdbccrud h(int id){

        jdbccrud select = a.select1(id);
        return select;
    }
}
