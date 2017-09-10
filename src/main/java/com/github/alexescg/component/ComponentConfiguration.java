package com.github.alexescg.component;


import com.github.alexescg.component.systeminfo.SystemInformationComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author alex
 */
@Configuration
public class ComponentConfiguration {

    @Bean
    public SystemInformationComponent informationComponent(){
        return new SystemInformationComponent();
    }

}
