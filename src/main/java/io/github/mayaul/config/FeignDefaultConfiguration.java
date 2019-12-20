package io.github.mayaul.config;

import feign.Contract;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignFormatterRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;

@Slf4j
@Configuration
public class FeignDefaultConfiguration {

    @Bean
    public Contract contract() {
        log.info("[bean] feign default contract");
        return new Contract.Default();
    }

    /**
     * RequestParam 에서 LocalDate, LocalDateTime, LocalTime 을 사용을 할 때 ISO formatter 로 보내기 위한 설정
     *
     * @see org.springframework.web.bind.annotation.RequestParam
     */
    @Bean
    public FeignFormatterRegistrar localDateFeignFormatterRegister() {
        log.info("[bean] feign local date formatter");
        return registry -> {
            DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
            registrar.setUseIsoFormat(true);
            registrar.registerFormatters(registry);
        };
    }
}
