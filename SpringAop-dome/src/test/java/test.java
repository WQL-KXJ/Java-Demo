import com.aop.proxy;
import com.aop.proxy_interface;
import com.service.tx_service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/transaction.xml"})
public class test {

    @Autowired
    proxy_interface proxy;

    @Autowired
    tx_service tx;

    @Test
    public void test(){

      tx.accounts("FQ","WQL",1000);

    }
}
