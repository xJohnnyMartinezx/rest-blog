package com.example.restblog.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {


}
