package kr.co.sboard.repository;

import kr.co.sboard.entity.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity,Integer> {

    // Pageable 객체는 게시글을 조회할 때 사용된다

    public Page<ArticleEntity> findByParentAndCate(int parent,String cate,Pageable pageable);

}
