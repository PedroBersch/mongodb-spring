package com.pedro.mongodbspring.repository;

import com.pedro.mongodbspring.domain.Post;
import com.pedro.mongodbspring.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

}
