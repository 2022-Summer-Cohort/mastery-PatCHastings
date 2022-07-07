package com.survivingcodingbootcamp.blog.model;


import javax.persistence.*;
import java.util.Collection;

@Entity
public class Hashtag {

    @Id
    @GeneratedValue
    private long id;
    private String hashtagToAdd;
    @ManyToMany(mappedBy = "hashtags")
    private Collection<Post> posts;

    public Hashtag(String hashtagToAdd) {
    this.hashtagToAdd = hashtagToAdd;
    }

    public Hashtag() {
    }

    public Collection<Post> getPosts() {
        return posts;
    }
    public long getId() {
        return id;
    }
    public String getHashtagToAdd() {
        return hashtagToAdd;
    }
}
