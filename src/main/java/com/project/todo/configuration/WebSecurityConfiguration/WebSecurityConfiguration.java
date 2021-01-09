package com.project.todo.configuration.WebSecurityConfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/api/**").authenticated()
                .and()
                .httpBasic()
                .and()
                .exceptionHandling()
                    .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .formLogin()
                    .loginProcessingUrl("api/login")
                .sucessHandler(loginSucessHandler)
                .failureHandler(new SimpleUrlAuthenticationFailureHandler());
        http.csrf().ignoringAntMatchers("/api/login").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }
}
