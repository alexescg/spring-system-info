package alexescg.com.github;

import alexescg.com.github.model.SystemInformation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

/**
 * @author alex
 */
@SpringBootApplication
public class SpringSystemInfoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringSystemInfoApplication.class, args);
    }
}

