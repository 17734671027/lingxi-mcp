package com.jcloud.lingxi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.concurrent.Executors;

// JDK17: 使用现代配置类和密封类特性
@Configuration
public class RestTemplateConfig {
    
    // JDK17: 使用现代超时配置
    private static final Duration CONNECT_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration READ_TIMEOUT = Duration.ofSeconds(10);
    
    @Bean
    public RestTemplate restTemplate() {
        // JDK17: 使用现代HTTP客户端配置
        var factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout((int) CONNECT_TIMEOUT.toMillis());
        factory.setConnectionRequestTimeout((int) READ_TIMEOUT.toMillis());
        
        // JDK17: 使用现代RestTemplate构建
        var restTemplate = new RestTemplate(factory);
        
        // JDK17: 使用现代错误处理
        restTemplate.setErrorHandler(new ModernResponseErrorHandler());
        
        return restTemplate;
    }
    
    // JDK17: 使用现代响应错误处理器
    private static class ModernResponseErrorHandler extends org.springframework.web.client.DefaultResponseErrorHandler {
        
        @Override
        public boolean hasError(org.springframework.http.client.ClientHttpResponse response) {
            try {
                // JDK17: 使用现代HTTP状态码检查
                return super.hasError(response) ||
                       response.getStatusCode().is4xxClientError() ||
                       response.getStatusCode().is5xxServerError();
            } catch (Exception e) {
                return true; // 如果无法确定，认为有错误
            }
        }
    }
}