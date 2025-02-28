package com.stock.stockservice;

import com.okta.spring.boot.oauth.Okta;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().oauth2ResourceServer().jwt();
        Okta.configureResourceServer401ResponseBody(http);
    }

    // @Override
    // protected void configure(HttpSecurity security) throws Exception {
    // security.httpBasic().and().cors().and().csrf().disable();
    // }
}
