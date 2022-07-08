package com.survivingcodingbootcamp.blog.repository;

import com.survivingcodingbootcamp.blog.model.Post;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Long> {
    Optional<Post> findByPostName(String postTitle);
}
