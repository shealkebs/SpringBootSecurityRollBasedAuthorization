package com.security.app.controller;

import org.springframework.boot.web.servlet.error.ErrorController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyErrorController implements ErrorController {

	
	@RequestMapping("/error")
    public ModelAndView handleError() {
		System.out.println("In error controller");
        return new ModelAndView("404");
    }
	@Override
	public String getErrorPath() {
		return "/error";
	}

}
