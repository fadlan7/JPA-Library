package com.enigma.enigpus_livecode.entity;

public class Novel extends Book{
    private String code;
    private String title;
    private String publisher;
    private String yearOfPublication;
    private String author;

    public Novel(String title, String publisher, String yearOfPublication, String author) {
        this.code = code;
        this.title = title;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
        this.author = author;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }
}
