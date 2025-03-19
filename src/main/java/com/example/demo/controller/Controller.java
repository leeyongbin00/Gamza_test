package com.example.demo.controller;

import com.example.demo.dto.Dto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class Controller {
    @Autowired
    private UserService userService;

    // 회원가입!
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody Dto userDTO) {
        userService.createUser(userDTO);
        return ResponseEntity.ok("회원가입 성공!");
    }

    // 전체 회원 조회!
    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.badRequest().body("회원 조회 실패!");
        }
    }

    // 특정 회원 조회!
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.badRequest().body("회원 조회 실패!");
        }
    }

    // 회원 정보 수정!
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@RequestBody Dto userDTO) {
        userService.updateUser(userDTO);
        return ResponseEntity.ok("회원 수정 성공!");
    }

    // 회원 삭제!
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("회원 삭제 성공!");
    }
}
