package com.example.demo.service;

import com.example.demo.dto.Dto;
import com.example.demo.entity.User;
import com.example.demo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private Repository userRepository;

    // 회원가입!
    public User createUser(Dto userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return userRepository.save(user);
    }

    // 전체 회원 조회!
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 특정 회원 조회!
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // 회원 정보 수정!
    public User updateUser(Dto userDTO) {
        return userRepository.findById(userDTO.getId()).map(user -> {
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            return userRepository.save(user);
        }).orElse(null);
    }

    // 회원 삭제!
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
