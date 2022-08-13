package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        users.forEach(System.out::println);
    }

    @Test
    void select() {
        System.out.println(userRepository.findByName("hi"));
    }
}