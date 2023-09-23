package com.springboot.section04restcrudprojectV2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails ahmed = User.builder()
                .username("ahmed")
                .password("{noop}ahmed")
                .roles("EMPLOYEE, MANAGER, ADMIN")
                .build();

        UserDetails nader = User.builder()
                .username("nader")
                .password("{noop}nader")
                .roles("EMPLOYEE, MANAGER")
                .build();

        UserDetails ali = User.builder()
                .username("ali")
                .password("{noop}ali")
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(ahmed, nader, ali);
    }

}
