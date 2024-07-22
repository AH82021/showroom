package com.armancodeblock.carShow.security;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// The API require authentication before processing a request
//
@Configuration
@EnableWebSecurity

public class SecurityConfig {
@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

      return http
              .httpBasic(Customizer.withDefaults())
              .authorizeHttpRequests(c->
                               c.anyRequest()
                              .authenticated())
                             .build();

      //CSRF (Cross Site Request Forgery) attacks
    //CORS(Cross-Origin Resource Sharing)

    }
    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails admin = User.builder()
                .username("admin")
                .password(bCryptPasswordEncoder().encode("adminPass"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(bCryptPasswordEncoder().encode("userPass"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);

    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
    return new BCryptPasswordEncoder();
    }
}
