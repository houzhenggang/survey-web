package edu.akdeniz.softeng.surveyrest.config.auth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class WebSecurityConf extends WebSecurityConfigurerAdapter {

	private String AD_DOMAIN = "bim.akdeniz.edu.tr";
	private String AD_URL = "ldap://10.44.0.5:389";

	   @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
	        authManagerBuilder.authenticationProvider(activeDirectoryLdapAuthenticationProvider()).userDetailsService(userDetailsService());
	    }

	    @Bean
	    public AuthenticationManager authenticationManager() {
	        return new ProviderManager(Arrays.asList(activeDirectoryLdapAuthenticationProvider()));
	    }
	    @Bean
	    public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
	        ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider(AD_DOMAIN, AD_URL);
	        provider.setConvertSubErrorCodesToExceptions(true);
	        provider.setUseAuthenticationRequestCredentials(true);

	        return provider;
	    }
	
}