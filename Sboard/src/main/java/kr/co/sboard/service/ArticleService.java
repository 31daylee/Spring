package kr.co.sboard.service;

import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.FileDTO;
import kr.co.sboard.dto.PageRequestDTO;
import kr.co.sboard.dto.PageResponseDTO;
import kr.co.sboard.entity.ArticleEntity;
import kr.co.sboard.repository.ArticleRepository;
import kr.co.sboard.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final FileRepository fileRepository;
    private final ModelMapper modelMapper;

    public PageResponseDTO findByParentAndCate(PageRequestDTO pageRequestDTO){
        //Pageable pageable = PageRequest.of(pg-1, 10, Sort.Direction.DESC, "no");

        Pageable pageable = pageRequestDTO.getPageable("no");
        Page<ArticleEntity> result= articleRepository.findByParentAndCate(0,pageRequestDTO.getCate(),pageable);

        // result.getContent 가 List. 그리고 그것과 연결 되어 있는 파이프 라인이 stream 이다. (stream 은 List 메모리에 할당되어 있는 것을 바로 참조한다. )
        // Map 은 각각의 element를 순회하는 for문의 역할을 한다. (자료 형변환 메서드 역할)
        List<ArticleDTO> dtoList = result.getContent()
                                            .stream()
                                            .map(entity -> modelMapper.map(entity, ArticleDTO.class))
                                            .toList();

        int totalElement = (int) result.getTotalElements(); // 전체 Entity element 갯수

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(totalElement)
                .build();
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
