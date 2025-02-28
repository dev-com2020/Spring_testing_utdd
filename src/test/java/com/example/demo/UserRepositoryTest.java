package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    private TestEntityManager entityManager;

    @Test
    void shouldSaveAndFindUserById(){
//        Given
        User user = new User(null,"Alice");
        User savedUser = userRepository.save(user);
//        When
        Optional<User> foundUser = (Optional<User>) userRepository.findById(savedUser.getId());
//        Then
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getName()).isEqualTo("Alice");
    }

    @Test
    void shouldPersistUser(){
//        Given
        User user = new User(null,"Alice");
        entityManager.persist(user);
        entityManager.flush();
//        When
        Optional<User> foundUser = (Optional<User>) userRepository.findById(1);
//        Then
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getName()).isEqualTo("Alice");
    }
}
