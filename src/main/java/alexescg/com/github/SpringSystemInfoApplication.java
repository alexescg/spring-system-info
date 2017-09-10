package alexescg.com.github;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author alex
 */
@ComponentScan("alexescg.com.github.component")
@SpringBootApplication
@EnableAutoConfiguration
public class SpringSystemInfoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringSystemInfoApplication.class, args);
    }
}
//TODO:hacer que se configure solo el endpoint con mi configuracion

