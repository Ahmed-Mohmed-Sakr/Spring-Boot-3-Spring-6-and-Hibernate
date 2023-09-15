package com.springboot.section02springbootcore.config;

import com.springboot.section02springbootcore.common.Coach;
import com.springboot.section02springbootcore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }

}
