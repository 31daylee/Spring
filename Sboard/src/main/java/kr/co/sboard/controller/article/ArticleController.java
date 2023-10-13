package kr.co.sboard.controller.article;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.PageRequestDTO;
import kr.co.sboard.dto.PageResponseDTO;
import kr.co.sboard.service.ArticleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/list")
    public String list(Model model, PageRequestDTO pageRequestDTO){
        PageResponseDTO pageResponseDTO = articleService.findByParentAndCate(pageRequestDTO);

        log.info("pageResponseDTO pg : "+ pageResponseDTO.getPg());
        log.info("pageResponseDTO size : "+ pageResponseDTO.getSize());
        log.info("pageResponseDTO total : "+ pageResponseDTO.getTotal());
        log.info("pageResponseDTO start : "+ pageResponseDTO.getStart());
        log.info("pageResponseDTO end : "+ pageResponseDTO.getEnd());
        log.info("pageResponseDTO prev : "+ pageResponseDTO.isPrev());
        log.info("pageResponseDTO next : "+ pageResponseDTO.isNext());

        model.addAttribute(pageResponseDTO);
        return "/article/list";
    }

    @GetMapping("/article/write")
    public String write(Model model, PageRequestDTO pageRequestDTO){

        // model.addAttribute(pageRequestDTO); ModelAttribute 가 생략 되어있어서 굳이 참조할 필요가 없다
        return "/article/write";
    }

    @PostMapping("/article/write")
    public String write(HttpServletRequest request, ArticleDTO dto){

        dto.setRegip(request.getRemoteAddr());
        articleService.save(dto);
        return "redirect:/article/list";
    }



}
