package com.pedro.mongodbspring.resources;

import com.pedro.mongodbspring.domain.Post;
import com.pedro.mongodbspring.domain.User;
import com.pedro.mongodbspring.dto.UserDto;
import com.pedro.mongodbspring.resources.util.URL;
import com.pedro.mongodbspring.services.PostService;
import com.pedro.mongodbspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {

        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }
    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> posts = postService.findByTitle(text);
        return ResponseEntity.ok().body(posts);
    }

}


