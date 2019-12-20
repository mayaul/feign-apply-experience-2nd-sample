package io.github.mayaul.feign.basic

import io.github.mayaul.basic.Client2
import io.github.mayaul.feign.TestConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = [TestConfiguration])
class Client2Test extends Specification {

    @Autowired
    Client2 client

    def "status"() {
        expect:
        client.status(200)
    }
}
