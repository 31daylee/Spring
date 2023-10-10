package kr.ch07.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ch07.dto.User1DTO;
import kr.ch07.dto.User6DTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class User6MapperTest {
	
	@Autowired
	private User6Mapper mapper;
	
	@Test
	public void insertUser6() {
		
		User6DTO user6 = User6DTO.builder()
				.uid("a111")
				.name("테스트")
				.birth("1986-06-25")
				.gender("M")
				.age(33)
				.addr("서울")
				.hp("010-1234-1561")
				.build();
		
		mapper.insertUser6(user6);
		
	}
	
	public void selectUser6() {
		
	}
	
	public void selectUser6s(){

	}
	
	
	public void updateUser6() {
		
	}
	
	
	public void deleteUser6() {
		
	}
	
	
}
