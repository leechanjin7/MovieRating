package com.example.demo.cotroller;

import com.example.demo.domain.dto.UserDTO;
import com.example.demo.service.RegisterMail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Service;

@Controller
@RequestMapping("/member")
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final RegisterMail registerMail;

    @GetMapping("/join")
    public String GETJoin(Model model) {

        log.info("회원가입 페이지 진입");
        model.addAttribute(new UserDTO());
        return "main";
    }

    @PostMapping("/mailConfirm")
    @ResponseBody
    String mailConfirm(@RequestParam("email") String email) throws Exception {

        String code = registerMail.sendSimpleMessage(email);
        System.out.println("인증코드 : " + code);
        return code;
    }

    @GetMapping("login")
    public void GETLogin(){
        log.info("로그인 페이지 진입");
    }

    @GetMapping("delete")
    public void remove(String userid){

    }

}
