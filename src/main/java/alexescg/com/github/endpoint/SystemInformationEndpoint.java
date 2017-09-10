package alexescg.com.github.endpoint;

import alexescg.com.github.model.SystemInformation;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author alex
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SystemInformationEndpoint {
    @Bean
    public static Endpoint systemInformationEndpoint() {
        return new Endpoint<SystemInformation>() {
            @Override
            public String getId() {
                return "info";
            }

            @Override
            public boolean isEnabled() {
                return true;
            }

            @Override
            public boolean isSensitive() {
                return false;
            }

            @Override
            public SystemInformation invoke() {
                try {
                    return new SystemInformation();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }
}
