package thoughtscript.io.bootexample.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import thoughtscript.io.webfluxexample.configurations.WebFluxConfiguration;
import thoughtscript.io.webfluxexample.services.ExampleReactiveService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static thoughtscript.io.bootexample.TestConstants.EXPECTED;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes={WebFluxConfiguration.class, WebFluxConfigurer.class, ExampleReactiveService.class})
class ExampleRestControllerIntegrationTest {

    @Autowired
    ExampleReactiveService exampleService;

    @Test
    void testA() {
        assertEquals(EXPECTED, exampleService.getAllExamples());
    }
}