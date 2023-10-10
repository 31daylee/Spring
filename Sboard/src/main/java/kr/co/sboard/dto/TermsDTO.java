package kr.co.sboard.dto;

import kr.co.sboard.entity.TermsEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TermsDTO {
    private Integer no;
    private String terms;
    private String privacy;

    // Entity 변환 메서드
    public TermsEntity toEntity() {
        return TermsEntity.builder()
                .no(no)
                .terms(terms)
                .privacy(privacy)
                .build();
    }
}
