package com.example.demo.cotroller;

import com.example.demo.domain.dto.MovieDTO;
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

//    영화목록(페이징 적용)
    @GetMapping("/main")
    public String list(Model model, @RequestParam(defaultValue = "1") int page) {
        Criteria criteria = new Criteria(page, 10); // 한 페이지당 10개의 아이템을 표시

        List<MovieDTO> list = movieService.moviePaging(criteria);
        int total = movieService.getTotal();

        PageMakerDTO pageMaker = new PageMakerDTO(criteria, total);

        model.addAttribute("list", list);
        model.addAttribute("pageMaker", pageMaker);
        model.addAttribute("criteria", criteria);

        return "main";
    }


}
