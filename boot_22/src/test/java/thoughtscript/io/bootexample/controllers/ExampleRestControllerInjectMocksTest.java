package thoughtscript.io.bootexample.controllers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.*;
import thoughtscript.io.bootexample.domain.Example;
import thoughtscript.io.bootexample.services.ExampleService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static thoughtscript.io.bootexample.TestConstants.EXPECTED;

@Slf4j
@ExtendWith(MockitoExtension.class)
class ExampleRestControllerInjectMocksTest {
    private final ResponseEntity<List<Example>> response = ResponseEntity.ok(EXPECTED);
    @InjectMocks
    ExampleRestController testController;
    @Mock
    ExampleService exampleService;

    @Test
    void testA() {
        when(exampleService.getAllExamples()).thenReturn(EXPECTED);
        assertEquals(response, testController.getAllExamples());
    }
}