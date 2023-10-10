package kr.ch08.entity.board;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="BoardArticle")
public class ArticleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT 의 역할 
	private int no;
	private String title;
	private String content;
	
	// 방향성을 고려해서 Article에서 File을 User를 참조해야 Article를 조회할 때 File이 동시에 참조됨 
	// @JoinColumn 선언으로 생성되는 컬럼
	// Article은 User와 n:1 관계 - 한명의 유저가 여러 개의 글을 작성할 수 있음
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="writer")
	private UserEntity user; 
	//private String writer; 단순한 writer가 아닌 userEntitiy의 user와 외래키 참조되어있으므로 위와 같이 연관 관계 설정필요

	@OneToOne(fetch=FetchType.LAZY, mappedBy = "article")
	private FileEntity file;
	
	// 방향성을 고려해서 Article에서 File을 User를 참조해야 Article를 조회할 때 File이 동시에 참조됨 
	// 양방향 관계에서 외래키를 갖는 엔티티의 속성을 mapperBy로 속성으로 연결 주인을 설정
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "article") //mappedBy는 CommentEntity의 연관된 속성을 작성해준다.
	//@JoinColumn 이름을 정의하지 않는다. Many를 당하는 comment 쪽에서 이름을 정의해준다 
	private List<CommentEntity> comments;
	
	@CreationTimestamp
	private LocalDateTime rdate;
	
	
}
