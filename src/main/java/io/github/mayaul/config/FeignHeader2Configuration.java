package io.github.mayaul.config;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@FeignConfiguration
public class FeignHeader2Configuration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        log.info("[bean] feign header2 configuration");
        return requestTemplate -> requestTemplate.header("header", "header2");
    }
}
