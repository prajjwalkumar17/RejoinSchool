package com.rejointech.Rejoinschool.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().denyAll()
//                .and().formLogin()
//                .and().httpBasic();
//    }
        @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .authorizeRequests()
                    .mvcMatchers("/dashboard").authenticated()
                    .mvcMatchers("/home").permitAll()
                    .mvcMatchers("/holidays/**").permitAll()
                    .mvcMatchers("/contact").permitAll()
                    .mvcMatchers("/saveMsg").permitAll()
                    .mvcMatchers("/courses").permitAll()
                    .mvcMatchers("/about").permitAll()
                    .mvcMatchers("/login").permitAll()
                    .and().formLogin().loginPage("/login")
                    .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll()
                    .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
                    .and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("1234").roles("user")
                .and()
                .withUser("admin").password("4321").roles("user","admin")
                .and().passwordEncoder(NoOpPasswordEncoder.getInstance());

        ;
    }
}