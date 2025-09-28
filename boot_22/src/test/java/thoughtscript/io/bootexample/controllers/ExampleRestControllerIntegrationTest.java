package thoughtscript.io.bootexample.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import thoughtscript.io.bootexample.services.ExampleService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static thoughtscript.io.bootexample.TestConstants.EXPECTED;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest()
class ExampleRestControllerIntegrationTest {

    @Autowired
    ExampleService exampleService;

    @Test
    void testA() {
        assertEquals(EXPECTED, exampleService.getAllExamples());
    }
}