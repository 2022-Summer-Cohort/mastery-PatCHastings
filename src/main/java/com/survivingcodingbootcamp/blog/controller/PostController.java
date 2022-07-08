package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostRepository postRepo;
    private HashtagRepository hashtagRepo;
    private TopicRepository topicRepo;

    public PostController(PostRepository postRepo) {
        this.postRepo = postRepo;
        this.hashtagRepo = hashtagRepo;
        this.topicRepo = topicRepo;
    }

    @GetMapping("/{id}")
    public String displaySinglePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postRepo.findById(id).get());
        return "single-post-template";
    }

    @PostMapping("/{id}/addHashtag")
private String addHashtag(@PathVariable Long id, @RequestParam String hashtagToAdd) {
        Post post1 = postRepo.findById(id).get();
        Optional<Hashtag> post1Hashtags = hashtagRepo.findByHashtagName(hashtagToAdd);
        if (post1Hashtags.isPresent()) {
            Hashtag post2Hashtag = new Hashtag(hashtagToAdd);
            post1.addHashtag(post2Hashtag);
        }
        else {
            post1.addHashtag(post1Hashtags.get());
            postRepo.save(post1);
        }
        return "redirect:/post/" + id;
    }
}
