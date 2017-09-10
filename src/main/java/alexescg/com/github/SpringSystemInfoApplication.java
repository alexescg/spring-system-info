package alexescg.com.github;

import alexescg.com.github.component.systeminfo.SystemInformation;
import alexescg.com.github.component.systeminfo.SystemInformationComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author alex
 */
@SpringBootApplication
@EnableAutoConfiguration
@Import(SystemInformationComponent.class)
public class SpringSystemInfoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringSystemInfoApplication.class, args);
    }

    @Component
    class SystemInformationComponent implements InfoContributor {

        @Override
        public void contribute(Info.Builder builder) {
            try {
                builder.withDetails(new SystemInformation().toMap());
            } catch (IOException e) {
                e.printStackTrace();
                Logger.getGlobal().log(Level.WARNING, "Custom system information info threw IOException");
            }
        }
    }
}

