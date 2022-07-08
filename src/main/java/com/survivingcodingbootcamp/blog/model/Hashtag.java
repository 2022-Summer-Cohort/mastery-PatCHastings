package com.survivingcodingbootcamp.blog.model;


import javax.persistence.*;
import java.util.Collection;

@Entity
public class Hashtag {

    @Id
    @GeneratedValue
    private long id;
    private String hashtagName;
    @ManyToMany(mappedBy = "hashtags")
    private Collection<Post> posts;

    public Hashtag(String hashtagName) {
    this.hashtagName = hashtagName;

    }

    public Hashtag() {
    }

//    public Hashtag(Hashtag hashtag) { Created when fixing error in postController
//
//    }

    public Collection<Post> getPosts() {
        return posts;
    }
    public long getId() {
        return id;
    }
    public String getHashtagName() {
        return hashtagName;
    }
}
