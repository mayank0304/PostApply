package com.mayank.joblisting.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mayank.joblisting.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
