package com.cloud.gateway.myFilter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("***********GlobalFilter***********");
        //获取request
        ServerHttpRequest request = exchange.getRequest();
        //获取请求参数wql,假如没有就拦截
        String name = request.getQueryParams().getFirst("wql");
        if(name==null){
            log.info("***********没有wql请求参数拦截***********");
            //拒绝请求
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        //放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() { //当前Filter的顺序，加入有多个Filter通过设置数字的大小来决定优先级，默认返回的数字越大优先级越高
        return 0;
    }
}

