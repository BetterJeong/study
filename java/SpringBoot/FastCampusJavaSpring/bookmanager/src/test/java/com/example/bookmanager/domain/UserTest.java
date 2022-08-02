package com.example.bookmanager.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void test() {
        User user = new User();
        user.setEmail("hi@hi.com");
        user.setName("난정");
        System.out.println(">>> " + user.toString());
    }

}