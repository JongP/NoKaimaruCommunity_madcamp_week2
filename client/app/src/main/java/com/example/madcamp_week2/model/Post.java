package com.example.madcamp_week2.model;

public class Post {

    private String id;
    private String title;
    private String content;
    private double rate;
    private int likeNum;

    private String writer;
    private String writerName;
    private String rest;

    private String postImg;
    private String restName;

    public String getPostImg() {
        return postImg;
    }

    public void setPostImg(String postImg) {
        this.postImg = postImg;
    }

    public Post(String id, String title, String content, double rate, String writer, String writerName, String rest, String restName, String postImg) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.rate = rate;
        this.writer = writer;
        this.writerName =writerName;
        this.rest = rest;
        this.restName = restName;
        this.postImg = postImg;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Post) {
            Post p = (Post) obj;

            return p.getId().equals(this.id);
        }
        return false;
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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getRest() {
        return rest;
    }

    public void setRest(String rest) {
        this.rest = rest;
    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }
}
