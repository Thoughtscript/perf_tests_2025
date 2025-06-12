package thoughtscript.io.bootexample.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thoughtscript.io.bootexample.domain.Example;
import thoughtscript.io.bootexample.services.ExampleService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/example")
public class ExampleRestController {

    @Autowired
    ExampleService exampleService;

    @GetMapping("/all")
    public ResponseEntity getAllExamples() {
        List<Example> result = exampleService.getAllExamples();
        return ResponseEntity.ok(result);
    }
}
