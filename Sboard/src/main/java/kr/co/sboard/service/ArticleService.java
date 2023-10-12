package kr.co.sboard.service;

import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public void save(ArticleDTO dto){

        articleRepository.save(dto.toEntity());
    }


}
