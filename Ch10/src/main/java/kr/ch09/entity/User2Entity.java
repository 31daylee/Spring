package kr.ch09.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="USER2")
public class User2Entity {

	@Id
	private String id;
	private String name;
	private String hp;
	private Integer age;
}
