package com.mysite.sbb.domain.study;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudyController {
    private final List<Integer> ages;
    @GetMapping("/study")
    @ResponseBody
    public List<Integer> beanTest(){
        return ages;
    }
}
