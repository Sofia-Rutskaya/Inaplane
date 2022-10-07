package com.Airtickets.Inaplane.config;

import com.Airtickets.Inaplane.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.net.PasswordAuthentication;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

private final UserDetailService userDetailService;
    @Autowired
    public WebSecurityConfig(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/auth/login", "/error", "/auth/registration", "/home", "/catalog/**" ).permitAll()
                .anyRequest().hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin().loginPage("/auth/login")
                .loginProcessingUrl("/process_login")
                .defaultSuccessUrl("/registration", true)
                .failureUrl("/auth/login?error")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/auth/login");
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailService)
              .passwordEncoder(getPasswordEncoder());
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
