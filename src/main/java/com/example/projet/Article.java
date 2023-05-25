package com.example.projet;

import java.io.Serializable;

public class Article implements Serializable {
    //les attributs
    private int id;
    private String title;
    private String content;
    private String author;
    private String date;

    //les constructeurs
    public Article (){}

    public Article(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
    public Article( String title, String author, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public Article(String title,String author, String content, String date) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
    }

    public Article(int id, String title, String content, String author, String date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
    }



    // Getters and setters

    public int getId() {return id;}
    public String getTitle() {return title;}
    public String getContent() {return content;}
    public String getAuthor() {return author;}
    public String getDate() {return date;}



    public void setId(int id) {this.id = id;}
    public void setTitle(String title) {this.title = title;}
    public void setAuthor(String author) {this.author = author;}
    public void setContent(String content) {this.content = content;}
    public void setDate(String date) {this.date = date;}













}

