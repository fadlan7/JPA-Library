package com.enigma.enigpus_livecode.entity;

import java.io.Serializable;

public class Books extends Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private String title;
    private String publisher;
    private Integer yearOfPublication;
    private String author;

    //magazine
//    private String code;
//    private String title;
    private String publicationPeriod;
//    private String yearOfPublication;



    public Books(String code, String title, String publisher, Integer yearOfPublication, String author) {
        this.code = code;
        this.title = title;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
        this.author = author;
    }

    public Books(String code,String title, String publicationPeriod, Integer yearOfPublication) {
        this.code = code;
        this.title = title;
        this.publicationPeriod = publicationPeriod;
        this.yearOfPublication = yearOfPublication;
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

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationPeriod() {
        return publicationPeriod;
    }

    public void setPublicationPeriod(String publicationPeriod) {
        this.publicationPeriod = publicationPeriod;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
