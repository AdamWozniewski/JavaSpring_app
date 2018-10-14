package com.clockworkjava.JavaSpring_app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
//                .antMatchers("/getKnights").hasAnyRole("USER", "ADMIN")
                .antMatchers("/getKnights").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/oneKnight").hasAnyAuthority("ADMIN")
//                .antMatchers("/oneKnight").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
//                .httpBasic(); // bazowy formularz
        .formLogin() // nasz formularz
        .defaultSuccessUrl("/getKnights");
    }

    @Autowired
    public void securityUsers(AuthenticationManagerBuilder auth) throws Exception {

//        auth.inMemoryAuthentication()
//                .withUser("user1").password("user1").roles("USER")
//                .and()
//                .withUser("user2").password("user2").roles("ADMIN");

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled FROM PLAYER_INFORMATION WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username, role FROM ROLE WHERE username = ?");

    }
}
