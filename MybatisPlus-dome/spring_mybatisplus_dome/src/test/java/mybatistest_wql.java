import com.mapper.mybatistest_mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring.xml"})
public class mybatistest_wql {

    @Autowired
    mybatistest_mapper mybatistest_mapper;

    @Test
    public void l() throws Exception {

        System.out.println(mybatistest_mapper.selere_id(1));

    }

}
