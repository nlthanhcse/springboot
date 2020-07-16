package com.springbootjap.springbootjpa.securityconfig;

import com.springbootjap.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/userapi/**")
                .hasAnyRole("ADMIN", "USER")
                .and().
                formLogin()
                .loginPage("/test/login");
    }

    @Autowired
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userService).passwordEncoder(encoder);
    }

    //    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.csrf().disable()
////                .authorizeRequests()
////                .antMatchers("/api/students")
////                .hasRole("admin")
////                .and()
////                .formLogin();
////        http.csrf().disable()
////                .authorizeRequests()
////                .antMatchers("/api/student/**")
////                .hasAnyRole("user")
////                .and()
////                .formLogin();
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/api/students")
//                .hasRole("admin")
//                .and()
//                .authorizeRequests()
//                .antMatchers("/api/student/**")
//                .hasAnyRole("user")
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll();
//    }
//
//    @Autowired
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("nlthanhcse").password("{noop}123").roles("admin", "user");
//        auth.inMemoryAuthentication().withUser("michaelcse").password("{noop}123").roles("user");
//    }
}
