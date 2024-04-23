package com.pedro.mongodbspring.repository;

import com.pedro.mongodbspring.domain.Post;
import com.pedro.mongodbspring.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
}
