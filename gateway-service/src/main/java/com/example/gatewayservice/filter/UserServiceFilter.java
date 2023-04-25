package com.example.gatewayservice.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class UserServiceFilter extends AbstractGatewayFilterFactory<UserServiceFilter.Args> {
    public UserServiceFilter() {
        super(Args.class);
    }

    @Data
    public static class Args {}

    @Override
    public GatewayFilter apply(UserServiceFilter.Args config) {
        return (exchange, chain) -> {
            log.info("UserServiceFilter start");

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("UserServiceFilter end");
            }));
        };
    }

}
