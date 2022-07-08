package com.survivingcodingbootcamp.blog.repository;

import com.survivingcodingbootcamp.blog.model.Topic;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface TopicRepository extends CrudRepository<Topic, Long> {
//    Optional<Topic> findByTopicName(String topicName);
}
