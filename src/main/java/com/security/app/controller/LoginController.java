package com.security.app.controller;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.security.app.model.UserLogin;
import com.security.app.service.SecureLoginService;



@RestController

public class LoginController {


	@Autowired
	SecureLoginService secureLoginService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login() {
//		System.out.println("In /login controller");
//        return "login";
//    }
//	
	
	@RequestMapping(value = "/postLogin", method = RequestMethod.GET)
    public ModelAndView postLogin(Model model, HttpSession session) {
        System.out.println("in to the post login controller");
        // read principal out of security context and set it to session
       // UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
       // validatePrinciple(authentication.getPrincipal());
       // UserLogin loggedInUser = ((LoginUserDetails) authentication.getPrincipal()).getUserDetails();
      //  model.addAttribute("currentUser", loggedInUser.getUsername());
       // session.setAttribute("userId", loggedInUser.getId());
        return new ModelAndView("welcome");
    }
	
	@RequestMapping(value = "/adminPage", method = RequestMethod.GET)
    public ModelAndView adminPage() {
        return new ModelAndView("welcomeAdmin");
    }
	
	@RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public ModelAndView userPage() {
        return new ModelAndView("welcomeUser");
    }
	
	@RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
    public ModelAndView loginError(Model model) {
       System.out.println(" In controller with url /loginFailed");
        return new ModelAndView("loginFailed");
    }
	
	@RequestMapping(value = "/signupUser", method = RequestMethod.POST)
	public ModelAndView SignupUser(@ModelAttribute("userLogin") UserLogin userLogin) {
		System.out.println("Hii in to sign up to register new user");
		if(userLogin.getPassword().equals(userLogin.getPasswordConfirm())) {
		userLogin.setPassword(bCryptPasswordEncoder.encode(userLogin.getPassword()));
		UserLogin user = secureLoginService.signupUser(userLogin);
		if(user.getStatusCode()==200) {
		return new ModelAndView("signupSuccess");
		}
		}
		return new ModelAndView("signup");
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView Signup() {
       System.out.println(" In controller with Sign up");
        return new ModelAndView("signup");
    }
	
	
	

	
	
//	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
//	public ModelAndView welcomePage() {
//		System.out.println("in welcome Controller with view return");
//		return new ModelAndView("welcome");
//	}
//	
	
	

}
