package alexescg.com.github.controller;

import alexescg.com.github.model.SystemInformation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author alex
 */
@RestController
public class SystemInformationController {

    @RequestMapping("/info")
    public SystemInformation getSystem() {
        try {
            return new SystemInformation();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
