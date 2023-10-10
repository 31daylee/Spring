package kr.ch09.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.ch09.dto.User3DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="USER3")
public class User3Entity {

	@Id
	private String id;
	private String name;
	private String hp;
	private Integer age;
	
	// DTO 변환 메서드
	public User3DTO toDTO() {
		
		return User3DTO.builder().id(id).name(name).hp(hp).age(age).build();
	}
}
