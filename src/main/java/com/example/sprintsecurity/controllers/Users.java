package com.example.sprintsecurity.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class Users {

    public String getUsers() {
        return "user";
    }

    public String getUser() {
        return "userDetail";
    }
}
