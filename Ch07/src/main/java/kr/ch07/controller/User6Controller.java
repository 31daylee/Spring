package kr.ch07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ch07.dto.User6DTO;
import kr.ch07.service.User6Service;

@Controller
public class User6Controller {
	
	// Controller-service 관계를 위한 service 선언
	@Autowired
	private User6Service service;

	// 등록_register
	@GetMapping("/user6/register")
	public String register() {
		return "/user6/register";
	}
	@PostMapping("/user6/register")
	public String register(User6DTO dto) {
		service.insertUser6(dto);
		return "redirect:/user6/list";					 // list 페이지로 리다이렉트
	}
	
	
	// 출력_list
	@GetMapping("/user6/list")
	public String list(Model model) { 					// Model 객체 이용
		List<User6DTO> users = service.selectUser6s();
		model.addAttribute("users",users);
		
		return "/user6/list";
	}
	
	// 수정_modify
	@GetMapping("/user6/modify")
	public String modify(String uid, Model model) {
		User6DTO dto = service.selectUser6(uid);
		model.addAttribute(dto);
		return "/user6/modify";
	}
	
	@PostMapping("/user6/modify")
	public String modify(User6DTO dto) {
		service.updateUser6(dto);
		return "redirect:/user6/list";
	}
	
	
	
	// 삭제_delete
	@GetMapping("/user6/delete")
	public String delete(String uid) {
		
		service.deleteUser6(uid);
		return "redirect:/user6/list";
	}
	
	
	
}
