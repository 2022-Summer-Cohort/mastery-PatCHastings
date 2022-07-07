package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
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

    public TopicController(TopicRepository topicRepo, PostRepository postRepo) {

        this.topicRepo = topicRepo;
        this.postRepo = postRepo;
    }
    @GetMapping("/{id}")
    public String displaySingleTopic(@PathVariable long id, Model model) {
        model.addAttribute("topic", topicRepo.findById(id).get());
        return "single-topic-template";
    }

    @PostMapping("/{id}/addPost")
    public String addReview(@PathVariable Long id, @RequestParam String title, @RequestParam String author, @RequestParam Topic topic, @RequestParam String content) {
        Topic topic1 = topicRepo.findById(id).get();
        Post post1 = new Post(title, author, topic, content);
        postRepo.save(post1);
        topic1.addPost(post1);
        topicRepo.save(topic1);
        return "redirect:/topics/" + id;
    }
}
