package com.security.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.security.app.service.SecureLoginService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new SecureLoginService();
	}

	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	@Autowired
	public SecurityConfig (AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		System.out.println("inside DaoAuthenticationProvider");
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		 authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		System.out.println("inside AuthenticationManagerBuilder");
		auth.authenticationProvider(authenticationProvider());
	}

	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("in HttpSecurity Config");
		http.authorizeRequests()
				.antMatchers("/welcomeAdmin").access("hasRole('ROLE_Admin')")
				.antMatchers("/welcomeUSER").access("hasRole('ROLE_USER')")
				.and()
			.formLogin().loginPage("/login")
				.loginProcessingUrl("/doLogin")
				.usernameParameter("username").passwordParameter("password").permitAll()
				.successHandler(authenticationSuccessHandler)
				//.defaultSuccessUrl("/postLogin",true)
				.failureUrl("/loginFailed")
				.and()
				.logout().logoutUrl("/doLogout").logoutSuccessUrl("/logout").permitAll()
				.and()
                .csrf().disable();
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.antMatchers("/welcomeAdmin").access("hasRole('ROLE_Admin')")

//	
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		System.out.println("in configure HttpSecurity");
//		http.authorizeRequests()
//			.antMatchers("/login")
//				.permitAll()
//				.antMatchers("/**")
//				.hasAnyRole("USER")
//			.and()
//				.formLogin()
//				.loginPage("/login.jsp")
//				.defaultSuccessUrl("/welcome",true)
//				
//				.failureUrl("/login.jsp?error=1")//.loginProcessingUrl("/welcome").successForwardUrl("/welcome")
//				.permitAll()
//			.and()
//				.logout()
//				.logoutSuccessUrl("/welcome.jsp");
//	}
}
