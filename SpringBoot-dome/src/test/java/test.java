import com.WQL.pojo.mywql;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;

@SpringBootTest
public class test {

    @Autowired
    DataSource dataSource;

    @Test
    public void qq(){
        System.out.println(dataSource.getClass());
    }



}
