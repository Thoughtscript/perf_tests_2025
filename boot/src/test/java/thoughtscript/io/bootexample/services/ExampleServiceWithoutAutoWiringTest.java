package thoughtscript.io.bootexample.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static thoughtscript.io.bootexample.TestConstants.EXPECTED;

@Slf4j
class ExampleServiceWithoutAutoWiringTest {

    private final ExampleService testService = new ExampleService();

    @Test
    void testA() {
        assertEquals(EXPECTED, testService.getAllExamples());
    }
}
