package com.config;

import com.bean.bean_test;
import com.bean.condition_test;
import com.bean.lazy_test;
import com.util.*;
import org.springframework.context.annotation.*;
import com.util.custon_util;

//配置类注解
@Configuration
//@ComponentScan(value = "com",excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM,classes = custon_util.class)})
//@ComponentScans(value = {@ComponentScan("com.bean"),@ComponentScan("com.bean")})
@Import(value = {condition_lin_util.class, importselect_util.class})
public class config_annotation {

    @Bean(value = "get_bean")
    @Scope(value = "prototype")
    public bean_test  get_bean(){

        return new bean_test("FQ_WQL",100);
    }

    @Bean(value = "get_lazy_bean")
    @Lazy
    public lazy_test get_lazy_bean(){

        System.out.println("启动时初始化！");
        return new lazy_test("FQ",10);
    }

    @Conditional(value = {condition_lin_util.class})
    @Lazy
    @Bean(value = "get_linux")
    public condition_test get_condition(){

        return new condition_test("linux");
    }

    @Conditional(value = condition_win_util.class)
    @Lazy
    @Bean(value = "get_windown")
    public condition_test get_win_condition(){

        return new condition_test("windown");
    }

    @Bean(value ="get_factory_bean")
    public factorybean_util get_factory_bean(){

        //返回的虽然是 factorybean_util对象，实际上是condition_test对象
        return new factorybean_util();
    }

}
