package thoughtscript.io.bootexample;

import lombok.experimental.UtilityClass;
import thoughtscript.io.webfluxexample.domain.Example;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class TestConstants {
    public static final List<Example> EXPECTED = new ArrayList<Example>(
            List.of(
                    new Example("1", "a"),
                    new Example("2", "b")
            ));
}
