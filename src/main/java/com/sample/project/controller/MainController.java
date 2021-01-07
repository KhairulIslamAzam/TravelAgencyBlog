package com.sample.project.controller;

import com.sample.project.dto.PostDto;
import com.sample.project.services.PostService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private PostService postService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String home(Model model) {
        List<PostDto> posts = postService.findAll();
        List<PostDto> tempPostDto = new ArrayList<>();

        for(PostDto postDto: posts){
            if(postDto.getIsPrivate().equalsIgnoreCase("public")){
                tempPostDto.add(postDto);
            }
        }

        model.addAttribute("homeposts", tempPostDto);
        return "index";
    }
}
