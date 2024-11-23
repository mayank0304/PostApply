package com.mayank.joblisting.Repository;

import java.util.List;

import com.mayank.joblisting.model.Post;

public interface SearchRepository {
    List<Post> findByText(String text);
}
