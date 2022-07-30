package com.wqls;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class fqbm  implements  imbwql{
    InputStream a = Resources.getResourceAsStream("mybatisconfig.xml");
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(a);
    List<bmswql> aw=null;
    public fqbm() throws IOException {
    }
    
    public List<bmswql> select() {
        String sqlid="com.wqls.imbwql.wqlfq";
        SqlSession sqlSession = sessionFactory.openSession();
        aw=sqlSession.selectList(sqlid);
        return aw;
    }
}
