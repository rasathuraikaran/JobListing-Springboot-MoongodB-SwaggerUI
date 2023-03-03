package com.example.joblistingspringbootmoongodb.controller;

import com.example.joblistingspringbootmoongodb.PostRepo;
import com.example.joblistingspringbootmoongodb.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepo postRepo;
    @ApiIgnore //remove all the predefined request
    @RequestMapping(value = "/")
    public  void redirect (HttpServletResponse response ) throws IOException {
        response.sendRedirect("/swagger-ui.html");

    }

    @GetMapping("/posts")
    public List<Post> getAllPost(){
        return  postRepo.findAll();

    }

    @PostMapping("/post")
    public Post addPost(@RequestBody  Post post){
        return  postRepo.save(post);


    }

}
