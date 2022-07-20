package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.survivingcodingbootcamp.blog.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/topics")
public class TopicController {

    private TopicRepository topicRepo;
    private PostRepository postRepo;
    private HashtagRepository hashtagRepo;


    public TopicController(TopicRepository topicRepo, PostRepository postRepo, HashtagRepository hashtagRepo) {

        this.topicRepo = topicRepo;
        this.postRepo = postRepo;
        this.hashtagRepo = hashtagRepo;
    }



    @GetMapping("/{id}") //rickie help
    public String displaySingleTopic(@PathVariable long id, Model model) {
        model.addAttribute("topic", topicRepo.findById(id).get());
        return "single-topic-template";
    }

    @PostMapping("/{id}/addPost")
    public String addReview(@PathVariable long id, @RequestParam String title, String author, String content) {
        Topic topic1 = topicRepo.findById(id).get();
        Post post1 = new Post(title, author, topic1, content);
        postRepo.save(post1);
        topic1.addPost(post1);
        topicRepo.save(topic1);
        return "redirect:/topics/" + id;
    }
}
