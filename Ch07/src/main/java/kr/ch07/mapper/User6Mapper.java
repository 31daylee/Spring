package kr.ch07.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.ch07.dto.User6DTO;

@Mapper
public interface User6Mapper {
	
	// Insert
	public void insertUser6(User6DTO dto);
	
	// Select
	public User6DTO selectUser6(String uid);
	
	// Select_List
	public List<User6DTO> selectUser6s();
	
	// Update
	public void updateUser6(User6DTO dto);
	
	// Delete
	public void deleteUser6(String uid);
}
