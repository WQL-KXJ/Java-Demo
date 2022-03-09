package com.dao;

import com.bean.jdbctemplatetest;
import org.omg.CORBA.Object;

import java.util.List;

public interface add_service_in {

    public int update(jdbctemplatetest template);

    public int alter(jdbctemplatetest template);

    public int delete(jdbctemplatetest template);

    public int[] add_batch(List<Object[]> value);

    public int[] alter_batch(List<Object[]> value);

    public int[] delete_batch(List<Object[]> value);
}
