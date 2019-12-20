package io.github.mayaul;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.mayaul.config.FeignConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.Locale;
import java.util.TimeZone;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(excludeFilters = {@ComponentScan.Filter(FeignConfiguration.class)})
public class Application implements Jackson2ObjectMapperBuilderCustomizer {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
        jacksonObjectMapperBuilder
                .featuresToEnable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)
                .featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .timeZone(TimeZone.getDefault())
                .modulesToInstall(new JavaTimeModule())
                .locale(Locale.getDefault())
                .simpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    }
}

