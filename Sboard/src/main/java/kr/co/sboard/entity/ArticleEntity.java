package kr.co.sboard.entity;

import jakarta.persistence.*;
import kr.co.sboard.dto.ArticleDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name= "Article")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private int parent;
    private int comment;
    private String cate;
    private String title;
    private String content;
    private int file;
    private int hit;
    private String writer;
    private String regip;

    @CreationTimestamp
    private LocalDateTime rdate;

    // DTO 변환 메서드
    public ArticleDTO toDTO() {
        return ArticleDTO.builder()
                .no(no)
                .parent(parent)
                .comment(comment)
                .cate(cate)
                .title(title)
                .content(content)
                .hit(hit)
                .writer(writer)
                .regip(regip)
                .rdate(rdate)
                .build();
    }

}