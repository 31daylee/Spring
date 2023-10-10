package kr.co.sboard.entity;


import jakarta.persistence.*;
import kr.co.sboard.dto.TermsDTO;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "Terms")
public class TermsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String terms;
    private String privacy;

    // Dto 변환 메서드
    public TermsDTO toDto() {
        return TermsDTO.builder()
                .terms(terms)
                .privacy(privacy)
                .build();
    }

}
