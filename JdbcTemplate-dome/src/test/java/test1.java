import com.bean.jdbctemplatetest;
import com.dao.select_dao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring.xml"})
public class test1 {

    @Autowired
    select_dao selectDao;

    @Test
    public void query_value(){

        int i = selectDao.query_int();
        System.out.println(i);
    }

    @Test
    public void query_bean(){

        jdbctemplatetest queue_bean = selectDao.queue_bean(1);
        System.out.println(queue_bean);
    }

    @Test
    public void query_list(){

        List<jdbctemplatetest> list = selectDao.queue_list();
        System.out.println(list);
    }
}
