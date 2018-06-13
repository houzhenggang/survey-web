package edu.akdeniz.softeng.surveyrest.config;

import edu.akdeniz.softeng.surveyrest.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author maemresen
 * <p>
 * Spring Security configuration for alpha version.
 * Users are stored in memory.
 */
@Configuration
@Profile("alpha")
public class WebSecurityAlphaConf extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(Constants.Credentials.USER_NAME).password(Constants.Credentials.ENCRYPTED_USER_PASS).authorities("Survey", "Admin");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/", "/home", "/survey/**").permitAll()
                .antMatchers("/secure/**").access("hasAnyAuthority('Survey')")
                .and().formLogin().loginPage("/login")
                .usernameParameter("ssoId").passwordParameter("password").successHandler(new CustomAuthenticationSuccessHandler())
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }

    // user1, emre, canberk  = akdeniz2018
}