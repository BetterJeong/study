package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
    User findByEmail(String email);
    User findUserByEmail(String email);
    User getByEmail(String email);
    User readByEmail(String email);
    User queryByEmail(String email);
    User searchByEmail(String email);
    User streamByEmail(String email);

    List<User> findFirst1ByName(String name);
    List<User> findTop1ByName(String name);
    List<User> findLast1ByName(String name);
    List<User> findByEmailAndName(String name, String email);

    List<User> findByCreatedAtAfter(LocalDateTime localDateTime);
    List<User> findByIdAfter(Long id);

    List<User> findByCreatedAtGreaterThanAnd(LocalDateTime yesterday);
    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);
    List<User> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);
    List<User> findByIdBetween(Long id1, Long id2);

    List<User> findByIdIsNotNull();
    List<User> findByIdIsNotEmpty();
    List<User> findByAddressIsNotEmpty();
    List<User> findByNameIn(List<String> names);
}
