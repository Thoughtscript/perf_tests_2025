package thoughtscript.io.bootexample.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import thoughtscript.io.webfluxexample.configurations.WebFluxConfiguration;
import thoughtscript.io.webfluxexample.services.ExampleReactiveService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static thoughtscript.io.bootexample.TestConstants.EXPECTED;

@Slf4j
@SpringBootTest(classes={WebFluxConfiguration.class, WebFluxConfigurer.class, ExampleReactiveService.class})
/*
 Apparently auto-wiring into a "basic" Jupiter test
 also requires this annotation now.
*/
public class ExampleServiceWithAutoWiringTest {
    @Autowired
    ExampleReactiveService testService;

    @Test
    void testA() {
        assertEquals(EXPECTED, testService.getAllExamples());
    }
}