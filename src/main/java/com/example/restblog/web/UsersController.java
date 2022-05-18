package com.example.restblog.web;
import com.example.restblog.data.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {



    List<User> users = new ArrayList<>();
    User user1 = new User(1L, "kungfupanda", "panda54@gmail.com", "pandafight");
    User user2 = new User(2L, "nacholibre69", "youaretoofat@gmail.com", "eskeleto");
    User user3 = new User(3L, "deweyfinn", "skoolofrock@gmail.com", "guitarbattle");



//    *********** GET ALL USERS ***********
    @GetMapping()
    public List<User> getAll() {

    }


}
