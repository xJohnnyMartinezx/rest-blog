package com.example.restblog.web;
import com.example.restblog.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@CrossOrigin
@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {



    List<User> users = new ArrayList<>();
    User user1 = new User(1L,"kungfupanda", "panda54@gmail.com", "pandafight");
    User user2 = new User(2L, "nacholibre69", "youaretoofat@gmail.com", "eskeleto");
    User user3 = new User(3L, "deweyfinn", "skoolofrock@gmail.com", "guitarbattle");



//    *********** GET ALL USERS ***********
    @GetMapping()
    public List<User> getAll() {
        users.add(user1);
        users.add(user2);
        users.add(user3);

        return users;
    }

    //******** GET BY ID *************

    @GetMapping("{id}")
    public User getById(@PathVariable Long id) {
        for (User user : getAll()) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        return new User();
    }

    //******** CREATE POST **********
    @PostMapping
    private void createUser(@RequestBody User newUser) {
        users.add(newUser);
        System.out.println("New user has been created");


    }

    //    ********* UPDATE POST **********
    @PutMapping("{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User updateUser) {
        System.out.println("The id is: " + id);
        System.out.println("User has been updated");
    }


    //    ********** DELETE POST **********
    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id) {
        System.out.println("User with ID of " + id + " has been deleted");
    }


}
