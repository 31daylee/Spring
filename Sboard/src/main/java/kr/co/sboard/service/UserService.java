package kr.co.sboard.service;

import kr.co.sboard.dto.TermsDTO;
import kr.co.sboard.dto.UserDTO;
import kr.co.sboard.entity.TermsEntity;
import kr.co.sboard.entity.UserEntity;
import kr.co.sboard.repository.TermsRepository;
import kr.co.sboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private TermsRepository termsRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public TermsDTO findByTerms() {
        TermsEntity findTerms = termsRepository.findById(1).orElseThrow(() -> new RuntimeException());
        TermsDTO dto = findTerms.toDto();

        return dto;
    }

    public void save(UserDTO dto){
        
        // 비밀번호 암호화
        dto.setPass1(passwordEncoder.encode(dto.getPass1()));
        
        // DTO를 Entity 로 변환
        UserEntity entity = dto.toEntity();

        // DB insert
        userRepository.save(entity);
    }

    public int countUid(String uid){
        return userRepository.countByUid(uid);
    }

}
