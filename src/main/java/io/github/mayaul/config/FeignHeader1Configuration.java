package io.github.mayaul.config;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class FeignHeader1Configuration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        log.info("[bean] feign header1 configuration");
        return requestTemplate -> requestTemplate.header("header", "header1");
    }
}
