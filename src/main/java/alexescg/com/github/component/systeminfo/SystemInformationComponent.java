package alexescg.com.github.component.systeminfo;

//import org.springframework.boot.actuate.info.Info;
//import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
        import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author alex
 */
@Component
@EnableAutoConfiguration
public class SystemInformationComponent implements InfoContributor {

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
