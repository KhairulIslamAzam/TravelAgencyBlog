package com.sample.project.controller;

import com.sample.project.dto.LocationDto;
import com.sample.project.dto.PostDto;
import com.sample.project.model.User;
import com.sample.project.services.LocationService;
import com.sample.project.services.PostService;
import com.sample.project.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    public PostService postService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private Helper helper;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimmerEditor);
    }

    @ModelAttribute
    public void init(Model model){
        List<LocationDto> locationDtos = locationService.findAll();
        model.addAttribute("locationdtos", locationDtos);
    }

    @GetMapping(value = "/posts")
    public String posts(Model model){
        User userInfo = helper.userInfo();
        List<PostDto> posts = postService.getAllPostByUserId(userInfo.getId());
        model.addAttribute("posts", posts);
        return "profile_page";
    }

    @GetMapping(value = "/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // create model attribute to bind form data
        PostDto postDto = new PostDto();
        theModel.addAttribute("postdto", postDto);
        return "/post_setup";
    }

    @PostMapping(value = "/post")
    public String  savePost(@ModelAttribute("postdto") PostDto postDto){
        postService.save(postDto);
        return "redirect:/posts";
    }

    @GetMapping("/showFormForUpdate")
    public String updateCustomer(@RequestParam("postId") Long theId, Model model){

        PostDto postDto = postService.findById(theId);
        model.addAttribute("postdto", postDto);
        return "/post_setup";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("postId") Long theId){

        postService.deleteById(theId);

        return "redirect:/posts";
    }
}
