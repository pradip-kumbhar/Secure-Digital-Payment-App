package com.payment.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.payment.repository.UserRepository;
import com.payment.entity.User;
import com.payment.dto.UserRequestDto;
import com.payment.exception.DuplicateEmailException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ✅ UPDATED METHOD
    public User createUser(UserRequestDto dto) {

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new DuplicateEmailException("Email already exists");
        }


        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());

        return userRepository.save(user);
    }
}
