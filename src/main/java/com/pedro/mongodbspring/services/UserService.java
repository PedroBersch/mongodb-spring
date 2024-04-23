package com.pedro.mongodbspring.services;

import com.pedro.mongodbspring.domain.User;
import com.pedro.mongodbspring.dto.UserDto;
import com.pedro.mongodbspring.repository.UserRepository;
import com.pedro.mongodbspring.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        List<User> list = userRepository.findAll();
        return list;
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public User fromDto(UserDto userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }

    public User update(User user) {
        User newObj = findById(user.getId());
        updateData(newObj, user);
        return userRepository.save(newObj);
    }

    private void updateData(User newUser, User oldUser) {
        newUser.setName(oldUser.getName());
        newUser.setEmail(oldUser.getEmail());
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }
}
