package com.pedro.mongodbspring.services;

import com.pedro.mongodbspring.domain.User;
import com.pedro.mongodbspring.dto.UserDto;
import com.pedro.mongodbspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        List<User> list = userRepository.findAll();
        return userRepository.findAll();
    }

}
