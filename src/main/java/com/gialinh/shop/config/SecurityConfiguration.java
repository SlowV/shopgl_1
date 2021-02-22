package com.gialinh.shop.config;

import com.gialinh.shop.domain.Account;
import com.gialinh.shop.domain.Role;
import com.gialinh.shop.service.impl.AccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author SlowV ❤ H3yae
 * @createdAt 2/19/21_9:51 AM
 * @updatedAt 2/19/21_9:51 AM
 */
@EnableWebSecurity
@Configuration
@Slf4j
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    final
    AccountServiceImpl accountService;

    public SecurityConfiguration(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        return email -> {
            Account account = accountService.findByEmail(email);
            if (account == null) {
                throw new UsernameNotFoundException("User not found");
            }
            Set<Role> roles = account.getRoles();
            int n = roles.size();
            String roleNames[] = new String[n];
            int i = 0;
            for (Role role : roles)
                roleNames[i++] = role.getName();
            return User.builder()
                    .username(account.getEmail())
                    .password(account.getPassword())
                    .roles("ADMIN", "USER")
                    .build();
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .and()
                .httpBasic()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/admin/login")
                .permitAll();
    }



}
