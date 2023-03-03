package com.example.joblistingspringbootmoongodb.controller;

import com.example.joblistingspringbootmoongodb.repository.PostRepo;
import com.example.joblistingspringbootmoongodb.model.Post;
import com.example.joblistingspringbootmoongodb.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepo postRepo;
    @Autowired
    SearchRepository searchRepository;
    @ApiIgnore //remove all the predefined request
    @RequestMapping(value = "/")
    public  void redirect (HttpServletResponse response ) throws IOException {
        response.sendRedirect("/swagger-ui.html");

    }

    @GetMapping("/posts")
    public List<Post> getAllPost(){
        return  postRepo.findAll();

    }

    @GetMapping("/posts/{text}")
    public List<Post> search (@PathVariable String text){
        return searchRepository.findByText(text);
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody  Post post){
        return  postRepo.save(post);


    }

}
