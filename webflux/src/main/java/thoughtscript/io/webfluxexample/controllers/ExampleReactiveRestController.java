package thoughtscript.io.webfluxexample.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import thoughtscript.io.webfluxexample.services.ExampleReactiveService;

@Slf4j
@RestController
public class ExampleReactiveRestController {

    @Autowired
    ExampleReactiveService exampleReactiveService;

    @GetMapping("/api/example/all")
    public Mono<ResponseEntity> getAllExamples() {
        return Mono.just(new ResponseEntity(exampleReactiveService.getAllExamples(), HttpStatus.OK));
    }
}
