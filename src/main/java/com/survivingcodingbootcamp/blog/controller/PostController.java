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
public String addHashtag(@PathVariable Long id, @RequestParam String hashtagToAdd, @RequestParam String hashtag) {
        Post post = postRepo.findById(id).get();
        Optional<Hashtag> post1Hashtags = hashtagRepo.findByHashtagToAdd(hashtag);
        if (post1Hashtags.isPresent()) {
            if (!post.getHashtags().contains(post1Hashtags.get())) {
                post.addHashtag(post1Hashtags.get());
            }
        }
        else {
            Hashtag hashtag1 = new Hashtag(hashtag);
            hashtagRepo.save(hashtag1);
            post.addHashtag(hashtag1);

        }
        postRepo.save(post);

        return "redirect:/posts/" +id;
    }
}
