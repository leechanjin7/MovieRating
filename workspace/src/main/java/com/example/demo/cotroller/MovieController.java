package com.example.demo.cotroller;

import com.example.demo.domain.dto.MovieDTO;
import com.example.demo.domain.dto.Search;
import com.example.demo.domain.paging.Criteria;
import com.example.demo.domain.paging.PageMakerDTO;
import com.example.demo.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;


    //    영화목록(페이징 적용)
    @GetMapping("/main")
    public void GETMovieList(Search search, Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "recommend") String orderBy){
        Criteria criteria = new Criteria(page, 10); /*페이지당 몇개의 포스터가 보여질 건지*/

        List<MovieDTO> list;

        if (orderBy.equals("recommend")) {
            list = movieService.getList(criteria, search);
        } else if (orderBy.equals("alphabetical")) {
            list = movieService.getList2(criteria, search);
        } else if (orderBy.equals("newworks")){
            list = movieService.getList3(criteria, search);
        } else {
            // 기본적으로 평점순으로 정렬하여 영화목록 조회
            list = movieService.getList(criteria, search);
        }

        model.addAttribute("list", list);


        int total = movieService.getTotal(search);
        PageMakerDTO pageMaker = new PageMakerDTO(criteria, total);

        int totalMovieCount = movieService.getTotal(search);
        model.addAttribute("totalMovieCount", totalMovieCount);
        model.addAttribute("pageMaker", pageMaker);
        model.addAttribute("criteria", criteria);
        model.addAttribute("orderBy", orderBy);
    }

    @GetMapping("/detail")
    public void getDetail(){

    }

    @GetMapping("/detail/{movieId}")
    public String showMovieDetail(@PathVariable int movieId, Model model) {
        MovieDTO movie = movieService.getMovieById(movieId);

        model.addAttribute("movie", movie);
        model.addAttribute("list", List.of(movie));
//        log.info(List.of(movie).toString());
        log.info("Movie Image URL: {}", movie.getMovieImg());

        return "detail";

    }


}