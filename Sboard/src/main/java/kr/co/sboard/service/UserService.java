package kr.co.sboard.service;

import kr.co.sboard.dto.TermsDTO;
import kr.co.sboard.entity.TermsEntity;
import kr.co.sboard.repository.TermsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private TermsRepository termsRepository;

    public TermsDTO findByTerms() {
        TermsEntity findTerms = termsRepository.findById(1).orElseThrow(() -> new RuntimeException());
        TermsDTO dto = findTerms.toDto();

        return dto;
    }

}
