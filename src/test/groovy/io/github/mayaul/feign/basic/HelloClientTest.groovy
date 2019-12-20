package io.github.mayaul.feign.basic

import feign.Response
import io.github.mayaul.basic.HelloClient
import io.github.mayaul.feign.TestConfiguration
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import spock.lang.Specification

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = [TestConfiguration])
class HelloClientTest extends Specification {

    @Autowired
    HelloClient helloClient

    def "fail"() {
        expect:
        Response response = helloClient.fail(HttpStatus.UNAUTHORIZED.value())

        if (HttpStatus.Series.valueOf(response.status) == HttpStatus.Series.SERVER_ERROR) {
            throw new IllegalStateException("server error 발생")
        }

        System.out.println(response)
    }

    def "array"() {
        given:
        List<String> anyValues = ["a", "b", "c"]

        when:
        List<String> results = helloClient.array(anyValues)

        then:
        results == anyValues
    }
}
