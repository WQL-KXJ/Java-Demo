import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq-publish.xml")
public class publishtest {

    //注入rabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void holleworld_test() {

        /*发送消息，只需要调用rabbittemplate中的方法即可
         * 参数：
         * String exchange：交换机名称
         * String routingKey：路由Key
         * Object object：消息实体(不需要转化为byte类型)
         * */
        rabbitTemplate.convertAndSend("spring_fanout_exchange", "", "通过RabbitMQTemplate的converrAndSennt发送消息");

    }


}
