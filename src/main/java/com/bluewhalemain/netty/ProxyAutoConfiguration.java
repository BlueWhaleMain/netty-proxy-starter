package com.bluewhalemain.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import reactor.netty.http.client.HttpClient;

/**
 * 自动代理配置
 *
 * @author BlueWhaleMain
 */
@AutoConfiguration
@ConditionalOnClass(HttpClient.class)
public class ProxyAutoConfiguration {
    @Configuration(proxyBeanMethods = false)
    protected static class ProxyCreator {
        private final Logger logger = LoggerFactory.getLogger(ProxyCreator.class);

        @Bean
        @ConditionalOnMissingBean
        public ClientHttpConnector clientHttpConnector() {
            logger.info("Creating HttpClient Connector...");
            return new ReactorClientHttpConnector(HttpClient.create().proxyWithSystemProperties());
        }
    }
}
