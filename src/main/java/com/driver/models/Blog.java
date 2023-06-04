package com.driver.models;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;



@Entity
@Table(name = "blog")
public class Blog{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    
    @Column(name = "pub_date")
    @CreationTimestamp
    private Date pubDate;

    //child - parent relation ship (child for user)
    @ManyToOne
    @JoinColumn
    User user;

    //parent to child (parent for images)
    @OneToMany(mappedBy="blog",cascade = CascadeType.ALL)
    List<Image> imageList = new ArrayList<>();

    //Constructors
    public Blog() {

    }

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Blog(String title, String content, Date pubDate) {
        this.title = title;
        this.content = content;
        this.pubDate = pubDate;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}