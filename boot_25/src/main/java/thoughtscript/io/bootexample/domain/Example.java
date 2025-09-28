package thoughtscript.io.bootexample.domain;
import lombok.Data;

// https://medium.com/@cleanCompile/why-you-should-stop-using-lombok-in-2025-5fe3cc44b7c9
@Data // May not work in Java 25 + Spring Boot 4, needed to add the methods below explicitly!!!
public class Example {
    private String id;
    private String name;

    public Example(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
