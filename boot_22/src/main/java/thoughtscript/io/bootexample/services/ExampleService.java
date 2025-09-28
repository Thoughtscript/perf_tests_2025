package thoughtscript.io.bootexample.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import thoughtscript.io.bootexample.domain.Example;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ExampleService {

    private final List<Example> examples = new ArrayList<Example>(
            List.of(
                    new Example("1", "a"),
                    new Example("2", "b")
            ));

    public List<Example> getAllExamples() {
        return examples;
    }
}
