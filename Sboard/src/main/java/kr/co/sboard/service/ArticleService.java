package kr.co.sboard.service;

import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.FileDTO;
import kr.co.sboard.entity.ArticleEntity;
import kr.co.sboard.repository.ArticleRepository;
import kr.co.sboard.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Log4j2
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final FileRepository fileRepository;


    public Page<ArticleEntity> findByParent(int pg){
        Pageable pageable = PageRequest.of(pg-1, 10, Sort.Direction.DESC, "no");
        Page<ArticleEntity> result= articleRepository.findByParent(0,pageable);

        return result;
    }

    public void save(ArticleDTO dto) {
        // 글 등록
        ArticleEntity savedEntity = articleRepository.save(dto.toEntity());
        
        // 파일 업로드
        FileDTO fileDTO = fileUpload(dto);

        if(fileDTO != null){
            // 파일 등록
            fileDTO.setAno(savedEntity.getNo());

            fileRepository.save(fileDTO.toEntity());
            savedEntity.setFile(1);
            articleRepository.save(savedEntity);
            log.info("fileEntity...2");
        }
    }

    @Value("${spring.servlet.multipart.location}")
    private String filePath;

    public FileDTO fileUpload(ArticleDTO dto) {
        MultipartFile mf = dto.getFname();

        if(!mf.isEmpty()){
            // 파일 첨부 했을 경우
            String path = new File(filePath).getAbsolutePath();

            String oName = mf.getOriginalFilename();
            String ext = oName.substring(oName.lastIndexOf("."));
            String sName = UUID.randomUUID().toString()+ext;

            try {
                mf.transferTo(new File(path, sName));
            } catch (IOException e) {
                log.error(e.getMessage());
            }

            return FileDTO.builder().ofile(oName).sfile(sName).build();
        }
        return null;
    }



}
