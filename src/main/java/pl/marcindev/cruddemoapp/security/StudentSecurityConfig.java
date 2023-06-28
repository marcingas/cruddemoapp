package pl.marcindev.cruddemoapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class StudentSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}123")
                .roles("EMPLOYEE")
                .build();
        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}123")
                .roles("EMPLOYEE","MANAGER")
                .build();
        UserDetails ann = User.builder()
                .username("ann")
                .password("{noop}123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(john,mary,ann);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
http.authorizeHttpRequests(configurer->
        configurer
        .requestMatchers(HttpMethod.GET,"/main/students").hasRole("EMPLOYEE")
        .requestMatchers(HttpMethod.GET,"/main/students/**").hasRole("EMPLOYEE")
        .requestMatchers(HttpMethod.POST,"/main/students").hasRole("MANAGER")
        .requestMatchers(HttpMethod.PUT,"/main/students").hasRole("MANAGER")
        .requestMatchers(HttpMethod.DELETE,"/main/students").hasRole("ADMIN")

);
http.httpBasic(Customizer.withDefaults());
  return http.build();
    }
}
