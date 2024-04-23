package com.pedro.mongodbspring.services;

import com.pedro.mongodbspring.domain.Post;
import com.pedro.mongodbspring.domain.User;
import com.pedro.mongodbspring.dto.UserDto;
import com.pedro.mongodbspring.repository.PostRepository;
import com.pedro.mongodbspring.repository.UserRepository;
import com.pedro.mongodbspring.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
    public List<Post> findByTitle(String text){
        return postRepository.findByTitleContaining(text);
    }
}
