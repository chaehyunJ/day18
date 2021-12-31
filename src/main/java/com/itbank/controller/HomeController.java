package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController{
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/login")
	public String login(String username, HttpSession session) {
		session.setAttribute("username", username);
		return "redirect:/main";
	}
	
	@GetMapping("/main")
	public void main() {}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
