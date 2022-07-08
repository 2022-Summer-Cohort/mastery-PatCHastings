package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class HomeController {
    private TopicRepository topicRepo;

    public HomeController(TopicRepository topicRepo) {

        this.topicRepo = topicRepo;
    }

    @GetMapping("/")
    public String displayHomePage(Model model) {
        model.addAttribute("topics", topicRepo.findAll());
        return "home-template";
    }

}

//    @PostMapping("/addTopic")
//    public String addTopic(@PathVariable Long id, @RequestParam String name, @RequestParam String topic) {
////        Optional<Topic> topicOptional = topicRepo.findByTopicName(name);
//        if (!topicOptional.isPresent()) {
//            Topic topic1 = new Topic(topic);
//            topicRepo.save(topic1);
//        }
//        return "redirect: ";
//    }
//}
