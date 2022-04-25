package springcloud.controller;

import com.cloud.commons.entities.payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springcloud.service.serviceimpl.PaymentServiceImpl;
import springcloud.util.CommonResult;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    PaymentServiceImpl paymentService;

    @Value("${server.port}")
    String server;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody payment pay){

        boolean b = paymentService.create(pay);

        if(b){
            log.info("----插入成功----");
            return new CommonResult(200,"插入成功:服务"+server);
        }
        return  new CommonResult(400,"插入失败");
    }

    @RequestMapping(value = "/select/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult create(@PathVariable("id") int id) {

        payment paymentByid = paymentService.getPaymentByid(id);
        if(paymentByid!=null){
            log.info("----查询成功-----");
            return new CommonResult<payment>(200,"查询成功:服务"+server,paymentByid);
        }
        return new CommonResult(400,"查询失败");
    }

    @RequestMapping("/time")
    @ResponseBody
    public String timeout(){

        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){e.printStackTrace();}
        return server;
    }

}
