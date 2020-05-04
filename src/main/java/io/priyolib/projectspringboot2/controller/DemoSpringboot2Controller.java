package io.priyolib.projectspringboot2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController()
@RequestMapping("/api")
public class DemoSpringboot2Controller {

    @ResponseBody
    @GetMapping("/demo")
    public String demo(){
        return "hello Springboot2";
    }
    @GetMapping("/welcome")
    public String welcome(Model model){
        log.info("welcome() called {}",model);
        model.addAttribute("message","welcome to springboot2");
        return "message";
    }
}
