package com.security.app.service;

import java.util.Arrays;
import java.util.HashSet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.app.model.Authority;
import com.security.app.model.LoginUserDetails;
import com.security.app.model.UserLogin;
import com.security.app.repository.UserAuthorityRepository;
import com.security.app.repository.UserLoginRepository;

@Service
public class SecureLoginService implements UserDetailsService {

	
	@Autowired
	 UserLoginRepository userLoginRepository;
	@Autowired
	UserAuthorityRepository userAuthorityRepository;
	
	@Autowired
	public JavaMailSender javaMailSender;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLogin userLogin=userLoginRepository.getUserByUsername(username);
    	if (userLogin == null) {
            throw new UsernameNotFoundException("User not found.");
        }     
        return new LoginUserDetails(userLogin);
	}
	public UserLogin signupUser(UserLogin userLogin) {
		
		Authority authority =userAuthorityRepository.findByRole(userLogin.getRole());
		userLogin.setAuthorities((new HashSet<Authority>(Arrays.asList(authority))));
		UserLogin user = userLoginRepository.getUserByUsername(userLogin.getUsername());
		if(user==null) {
				user = userLoginRepository.save(userLogin);		
		if(user!=null) {
			SimpleMailMessage message = new SimpleMailMessage();
			if (userLogin.getUserMail() != null) {
				message.setTo(userLogin.getUserMail());
				message.setSubject("Sign up Details");
				message.setText("The Entered Details by User : "+userLogin.getUsername()+ " With Password : "+userLogin.getPasswordConfirm());
				javaMailSender.send(message);
			}
			user.setStatusCode(200);
			return user;
		}
		}
		//userName already exist
		user.setStatusCode(400);
		return user;
	}
}
