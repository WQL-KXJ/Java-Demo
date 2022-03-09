import com.bean.jdbctemplatetest;
import com.component.template;
import com.config.datasource_config;
import com.dao.add_service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring.xml"})
public class test {

    @Autowired
    add_service dao;


    @Test
    public void test(){

        jdbctemplatetest jdbctemplatetest = new jdbctemplatetest();
        jdbctemplatetest.setId(3);
        jdbctemplatetest.setName("FQ");
        jdbctemplatetest.setAge(100);

         dao.update(jdbctemplatetest);
    }

    @Test
    public void alter(){
        jdbctemplatetest jdbctemplatetest = new jdbctemplatetest();
        jdbctemplatetest.setId(1);
        jdbctemplatetest.setName("FQ");
        jdbctemplatetest.setAge(18);
        int alter = dao.alter(jdbctemplatetest);
        System.out.println(alter);
    }

    @Test
    public void delete(){
        jdbctemplatetest jdbctemplatetest = new jdbctemplatetest();
        jdbctemplatetest.setId(2);
        int delete = dao.delete(jdbctemplatetest);
        System.out.println(delete);
    }



}

