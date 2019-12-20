package io.github.mayaul.basic;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "client", url = "${external-api.http-bin}")
public interface Client {

    @RequestLine("GET /status/{status}")
    void status(@Param("status") int status);
}
