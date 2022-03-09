package com.wql;

import java.util.List;

public interface Iuser {
    //查询数据
    public List<user> findall();

    //增加数据(插入数据传入对象)
    public int insert(user wql);

    //删除数据
    public void delete(int a);

    //更新数据
    public int update(user u);
}
