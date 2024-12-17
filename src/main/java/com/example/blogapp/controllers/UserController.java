package com.example.blogapp.controllers;

import com.example.blogapp.models.entities.AppUser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@ResponseBody /*(not needed here) automatically makes the object returned in java into json format which is later converted to http response*/
@RestController /*(@Rest Controller is a combo of @ResponseBody and @Controller) @Controller is used to make a java class as a spring MVC controller*/
@RequestMapping("/api/users")
public class UserController {

    // In-memory list to simulate a database
    private final List<AppUser> users = new ArrayList<>();

    // Endpoint to get all users (simulating data retrieval from a DB)...or rather a GET request
    @GetMapping
    public List<AppUser> getAllUsers() {
        return users;  // Returning all users from the in-memory list
    }
    //find the users at http://localhost:8080/users

    // Endpoint to add a new user (simulating saving data in a DB)...or rather a POST Request
    @PostMapping
    public AppUser addUser(@RequestBody AppUser user) {
        // Adding the user to the in-memory list (in real apps, this would save to a database)
        users.add(user);
        return user;  // Returning the added user
    }
}
