package com.example.joblistingspringbootmoongodb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class PostController {
    @ApiIgnore //remove all the predefined request
    @RequestMapping(value = "/")
    public  void redirect (HttpServletResponse response ) throws IOException {
        response.sendRedirect("/swagger-ui.html");

    }

}
