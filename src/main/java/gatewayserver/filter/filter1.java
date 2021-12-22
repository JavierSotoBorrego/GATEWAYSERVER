package gatewayserver.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;
@Component
public class filter1 implements GlobalFilter, Ordered {
    Logger logger = LoggerFactory.getLogger(filter1.class);
    @Override
    public int getOrder() {
        return 1;
    }
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("first pre filter");
        return chain.filter(exchange).then(Mono.fromRunnable(() ->
        logger.info("first post filter")
        ));
    }
}