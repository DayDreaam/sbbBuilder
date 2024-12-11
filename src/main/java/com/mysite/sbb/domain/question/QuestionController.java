package com.mysite.sbb.domain.question;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/question")
@Controller
public class QuestionController {
    @GetMapping("/list")
    @ResponseBody
    public String list(){
        return "question list";
    }
}
