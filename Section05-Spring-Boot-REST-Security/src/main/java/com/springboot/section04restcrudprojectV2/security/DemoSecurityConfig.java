package com.springboot.section04restcrudprojectV2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    /**
     * to use in memory users but with our custom tables
     */
        @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
            JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

            jdbcUserDetailsManager.setUsersByUsernameQuery(
                    "select user_id, pw, active from members where user_id=?"
            );

            jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                    "select user_id, role from roles where user_id=?"
            );

            return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")

        );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    /**
     * add support for JDBC users
     */
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }


    /**
     * to use in memory users
     */
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails ahmed = User.builder()
//                .username("ahmed")
//                .password("{noop}ahmed")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//
//        UserDetails nader = User.builder()
//                .username("nader")
//                .password("{noop}nader")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//
//        UserDetails ali = User.builder()
//                .username("ali")
//                .password("{noop}ali")
//                .roles("EMPLOYEE")
//                .build();
//
//        return new InMemoryUserDetailsManager(ahmed, nader, ali);
//    }


}
