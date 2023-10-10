package ch05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ch05.dto.User2DTO;
import ch05.service.User2Service;


@Controller
public class User2Controller {
	
	@Autowired
	private User2Service service;
	
	@GetMapping("/user2/register")
	public String register() {
		
		return "/user2/register";
	}
	
	@PostMapping("/user2/register")
	public String register(@ModelAttribute User2DTO dto) {
		return "redirect:/user1/list";
	}
	
	
	@GetMapping("/user2/list")
	public String list(Model model) {
		
		
		return "/user2/list";
	}
	
	@GetMapping("/user2/modify")
	public String modify(String uid, Model model) {
		
		
		return "/user2/modify";
	}
	
	@PostMapping("/user2/modify")
	public String modify(@ModelAttribute User2DTO dto) {
		
		return "redirect:/user2/list";
	}
	
	
	@GetMapping("/user2/delete")
	public String delete(String uid, Model model) {
		
		service.deleteUser1(uid);
		return "redirect:/user2/list";
	}
	
	
}
