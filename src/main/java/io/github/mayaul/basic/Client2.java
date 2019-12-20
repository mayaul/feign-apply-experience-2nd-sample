package io.github.mayaul.basic;

import feign.Param;
import feign.RequestLine;
import io.github.mayaul.config.FeignHeader2Configuration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "client2", url = "${external-api.http-bin}", configuration = {FeignHeader2Configuration.class})
public interface Client2 {

    @RequestLine(value = "GET /status/{status}")
    void status(@Param("status") int status);
}
