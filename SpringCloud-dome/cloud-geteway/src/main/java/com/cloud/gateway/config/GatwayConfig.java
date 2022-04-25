package com.cloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatwayConfig {

    @Bean
    public RouteLocator gatewayroute(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //route的参数id为路由的唯一ID，r.path就是路由的地址(通过断言进行匹配)，url为服务地址
        RouteLocator path_route = routes.route("path_route", r -> r.path("/2022/03/23/spring-session/").uri("https://wql.luoqin.ltd/")).build();
        return path_route;
    }
}
