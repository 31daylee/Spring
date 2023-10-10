package kr.ch07.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import kr.ch07.mapper.User6Mapper;
import kr.ch07.service.User6Service;

//@WebMvcTest은 에러 발생으로 아래 어노테이션으로 교체
@AutoConfigureMockMvc
@SpringBootTest
public class User6ControllerTest {

	//MVC 테스트를 위한 가상 MVC 객체
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private User6Service service;
	
	@Autowired
	private User6Mapper mapper;
	
	@Test
	public void list() throws Exception {
		mvc
		.perform(get("/user6/list")) 			// index 요청 테스트
		.andExpect(status().isOk())				// 요청 결과 상태 테스트
		.andExpect(view().name("/user6/list"))	// 반환되는 View 이름 테스트
		.andDo(print());
		
		
	}
	
	
}
