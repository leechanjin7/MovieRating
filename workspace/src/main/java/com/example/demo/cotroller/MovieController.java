package com.example.demo.cotroller;

import com.example.demo.domain.dto.MovieDTO;
import com.example.demo.domain.dto.Search;
import com.example.demo.domain.paging.Criteria;
import com.example.demo.domain.paging.PageMakerDTO;
import com.example.demo.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class MovieController {

    @Autowired
    private MovieService movieService;

//    @GetMapping("/main")
//    public String GETMainPage() {
//
//        log.info("메인 페이지 진입");
//
//        return "/main";
//    }

    @GetMapping("detail")
    public void GETDetail(){

    }

    //영화검색 + 페이징
    @GetMapping("/main")
    public void GETMovieList(Search search, Model model, @RequestParam(defaultValue = "1") int page ){
        Criteria criteria = new Criteria(page, 10); // 한 페이지당 10개의 아이템을 표시
//        System.out.println("GET movielist " + search);
        List<MovieDTO> list = movieService.getList(criteria, search);
        model.addAttribute("list", list);

        int total = movieService.getTotal(search);
//        System.out.println("Count : " + total);
        PageMakerDTO pageMaker = new PageMakerDTO(criteria, total);

        int totalMovieCount = movieService.getTotal(search);
        model.addAttribute("totalMovieCount", totalMovieCount);
        model.addAttribute("pageMaker", pageMaker);
        model.addAttribute("criteria", criteria);
    }

    @GetMapping("/login")
    public String login(){
        System.out.println("로그인 확인!");
        return "main";
    }

//    @GetMapping("/logout")
//    public String logout(){
//        System.out.println("로그아웃 확인");
//        return "main";
//    }
}
