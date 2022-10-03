package com.tedu.java.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author： zyy
 * @date： 2022/10/2 9:58
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_routh_zyy",r->r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
