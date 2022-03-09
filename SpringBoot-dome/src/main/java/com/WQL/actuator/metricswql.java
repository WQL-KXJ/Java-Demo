package com.WQL.actuator;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

//假定这是一个业务类
@Service
public class metricswql {

    Counter counter;
    //在构造中传入一个MeterRegistry
    public metricswql(MeterRegistry meterRegistry) {
        //传入一个计算指标
        counter = meterRegistry.counter("url调用计数");
    }
    //业务方法
    public void wlq(){
        //调用计算
        counter.increment();
    }
}
