package thoughtscript.io.bootexample.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import thoughtscript.io.webfluxexample.services.ExampleReactiveService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static thoughtscript.io.bootexample.TestConstants.EXPECTED;

@Slf4j
class ExampleServiceWithoutAutoWiringTest {

    private final ExampleReactiveService testService = new ExampleReactiveService();

    @Test
    void testA() {
        assertEquals(EXPECTED, testService.getAllExamples());
    }
}
