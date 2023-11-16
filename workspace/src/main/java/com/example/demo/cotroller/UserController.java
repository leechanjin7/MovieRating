package com.example.demo.cotroller;

import com.example.demo.domain.dto.UserDTO;
import com.example.demo.service.RegisterMail;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/member")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final RegisterMail registerMail;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/join")
    public void GETJoin() {

        log.info("회원가입 페이지 진입");
    }

    //회원가입
    @PostMapping("/join")
    @ResponseBody
    public Map<String, String> userJoin(UserDTO userDTO) {
        Map<String, String> result = new HashMap<>();
        try {
            // 비밀번호를 BCrypt로 해싱하여 저장
            String encodedPassword = passwordEncoder.encode(userDTO.getUserPw());
            userDTO.setUserPw(encodedPassword);

            //회원 가입 서비스 호출
            userService.userJoin(userDTO);
            result.put("message", "회원가입이 성공적으로 이루어졌습니다. 로그인 후 이용해주세요.");
            result.put("status", "success");
        } catch (Exception e) {
            result.put("message", "회원가입에 실패하였습니다. 다시 시도해주세요.");
            result.put("status", "fail");
        }
        return result;
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
