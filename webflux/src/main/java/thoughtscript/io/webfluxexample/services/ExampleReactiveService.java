package thoughtscript.io.webfluxexample.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import thoughtscript.io.webfluxexample.domain.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class ExampleReactiveService {

    private final List<Example> examples = new ArrayList<Example>(
            List.of(
                    new Example("1", "a"),
                    new Example("2", "b")
            ));

    public List<Example> getAllExamples() {
        Stream<Example> stream = examples.stream();
        return stream.collect(Collectors.toList());
    }
}

