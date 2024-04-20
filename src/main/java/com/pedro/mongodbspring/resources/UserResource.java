package com.pedro.mongodbspring.resources;

import com.pedro.mongodbspring.domain.User;
import com.pedro.mongodbspring.dto.UserDto;
import com.pedro.mongodbspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService userService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> findAll(){
        List<UserDto> list = userService.findAll().stream().map(x -> new UserDto(x)).toList();
        return ResponseEntity.ok().body(list);
    }
    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    public ResponseEntity<UserDto> findById(@PathVariable String id){

        User user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDto(user));
    }}
