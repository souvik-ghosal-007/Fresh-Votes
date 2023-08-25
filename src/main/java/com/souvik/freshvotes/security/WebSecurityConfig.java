package com.souvik.freshvotes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetails() {
        UserDetails user = User.builder()
                .username("souvik")
                .password("root")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer.requestMatchers("/").permitAll()
        )
                .formLogin(form ->
                        form.loginPage("/login").permitAll()
                )
                .logout(logout -> logout.logoutUrl("/logout").permitAll());

        return http.build();
    }

}
