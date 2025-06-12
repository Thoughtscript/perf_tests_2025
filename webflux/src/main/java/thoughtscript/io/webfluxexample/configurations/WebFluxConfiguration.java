package thoughtscript.io.webfluxexample.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import static thoughtscript.io.webfluxexample.configurations.Constants.CORS_ALLOWED_ORIGINS;
import static thoughtscript.io.webfluxexample.configurations.Constants.CORS_MAX_AGE;

@Configuration
@EnableWebFlux
public class WebFluxConfiguration implements WebFluxConfigurer {


    /**
     * CORS configuration
     */

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins(CORS_ALLOWED_ORIGINS)
                .allowedMethods("POST", "GET", "PUT", "DELETE")
                .allowCredentials(false).maxAge(CORS_MAX_AGE);
    }
}
