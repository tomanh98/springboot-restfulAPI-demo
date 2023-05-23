package com.example.restfulapi.controllers;

import com.example.restfulapi.entity.ResponseObject;
import com.example.restfulapi.entity.UserEntity;
import com.example.restfulapi.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "users")
public class UserController {
    @Autowired //DI = Dependency Injection
    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("")
    public List<UserEntity> getListUser() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getUserById(@PathVariable Long id) {
        Optional<UserEntity> foundUser = userRepository.findById(id);
        if (foundUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Succes", "Query user successfully", foundUser)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Failed", "Query user fail", "")
            );
        }
    }

    @GetMapping("name/{name}")
    public ResponseEntity<ResponseObject> getUserByName(@PathVariable String name) {
        List<UserEntity> foundUser = userRepository.findByName(name);
        if (foundUser.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Succes", "Query user successfully", foundUser)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Failed", "Query user fail", "")
            );
        }
    }

    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody UserEntity newUser) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Succes", "Query user successfully", userRepository.save(newUser))
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateUser(@PathVariable Long id, @RequestBody UserEntity newUser) {
        UserEntity updatedUser = userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setPhone(newUser.getPhone());
                    user.setAvatar(newUser.getAvatar());
                    user.setPassword(newUser.getPassword());
                    return userRepository.save(user);
                }).orElseGet(() -> {
                   newUser.setId(id);
                   return userRepository.save(newUser);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Succes", "Update user successfully", updatedUser)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id) {
        boolean exists = userRepository.existsById(id);
        if (exists) {
            userRepository.deleteById(id);
             return ResponseEntity.status(HttpStatus.OK).body(
                     new ResponseObject("Succes", "Delete user successfully", "")
             );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Failed", "Cannot find product to delete", "")
            );
        }
    }

}
