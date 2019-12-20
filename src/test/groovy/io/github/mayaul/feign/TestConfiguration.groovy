package io.github.mayaul.feign

import io.github.mayaul.config.FeignConfiguration
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

import java.lang.annotation.Annotation

@Configuration
@EnableFeignClients
@ComponentScan(basePackages = "io.github.mayaul", excludeFilters = [@ComponentScan.Filter(type = FilterType.ANNOTATION, value = FeignConfiguration.class)])
class TestConfiguration {
}
