package kr.co.sboard.controller.user;

import kr.co.sboard.dto.TermsDTO;
import kr.co.sboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/user/login")
    public String login(){
        return "/user/login";
    }

    @GetMapping("/user/terms")
    public String list(Model model) {

        TermsDTO terms = userService.findByTerms();
        model.addAttribute("terms",terms);

        return "/user/terms";
    }
}
