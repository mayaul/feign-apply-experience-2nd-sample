package io.github.mayaul.config;

import org.springframework.cloud.openfeign.FeignFormatterRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;

import java.lang.annotation.*;

/**
 * <code>@Configuration</code> 을 넣게 되면, @ComponentScan 에서 exclude 를 해야한다.
 * 그렇지 않으면 다른 feign client 에도 설정이 적용이 된다.
 *
 * <a href="http://woowabros.github.io/experience/2019/05/29/feign.html">feign</a>
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FeignConfiguration {


}
