package com.survivingcodingbootcamp.blog.controller;


import com.survivingcodingbootcamp.blog.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hashtags")
public class HashtagController {

    private HashtagRepository hashtagRepo;
    private TopicRepository topicRepo;
    private PostRepository postRepo;

    public HashtagController(HashtagRepository hashtagRepo, TopicRepository topicRepo, PostRepository postRepo) {
        this.hashtagRepo = hashtagRepo;
        this.topicRepo = topicRepo;
        this.postRepo = postRepo;
    }

    @RequestMapping("")
    public String showAllHashtags(Model model) {
       model.addAttribute("hashtags", hashtagRepo.findAll());
       return "all-hashtags-template";
    }
    @RequestMapping("/{id}")
    private String showHashtag(Model model, @PathVariable long id) {
        model.addAttribute("hashtag", hashtagRepo.findById(id).get());
        return "single-hashtag-template";
    }
}
