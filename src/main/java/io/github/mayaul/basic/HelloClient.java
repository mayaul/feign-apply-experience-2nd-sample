package io.github.mayaul.basic;

import feign.CollectionFormat;
import feign.Param;
import feign.RequestLine;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = "hello-client", url = "http://localhost:8080")
public interface HelloClient {

    @RequestLine("GET /fail/{status}")
    Response fail(@Param("status") int status);

    @RequestLine(value = "GET /array?values={values}", collectionFormat = CollectionFormat.CSV)
    List<String> array(@Param("values") List<String> values);
}
