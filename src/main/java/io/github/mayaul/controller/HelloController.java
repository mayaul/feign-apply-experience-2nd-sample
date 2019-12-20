package io.github.mayaul.controller;

import io.github.mayaul.response.HelloResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/fail/{status}")
    public ResponseEntity<HelloResponse<String>> sample(@PathVariable("status") int status) {
        return new ResponseEntity<>(HelloResponse.of(4000, "It's fail", "this is messages"),
                HttpStatus.valueOf(status));
    }

    @GetMapping("/array")
    public ResponseEntity<List<String>> array(@RequestParam("values") List<String> values) {
        return new ResponseEntity<>(values, HttpStatus.OK);
    }
}
