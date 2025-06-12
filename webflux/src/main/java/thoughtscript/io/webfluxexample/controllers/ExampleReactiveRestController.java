package thoughtscript.io.webfluxexample.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;
import thoughtscript.io.webfluxexample.services.ExampleReactiveService;

@Slf4j
@RequestMapping("/api/example")
public class ExampleReactiveRestController {

    @Autowired
    ExampleReactiveService exampleReactiveService;

    @GetMapping("/all")
    public Mono<ResponseEntity> getAllExamples() {
        return Mono.just(new ResponseEntity(exampleReactiveService.getAllExamples(), HttpStatus.OK));
    }
}
