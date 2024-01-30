package com.enigma.enigpus_livecode.entity;

import java.io.Serializable;

public class Books extends Book implements Serializable {
    private String code;
    private String title;
    private String publisher;
    private String yearOfPublication;
    private String author;

    //magazine
//    private String code;
//    private String title;
    private String publicationPeriod;
//    private String yearOfPublication;


    public Books(String title, String publisher, String yearOfPublication, String author) {
        this.code = code;
        this.title = title;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
        this.author = author;
    }

    public Books(String title, String publicationPeriod, String yearOfPublication) {
        this.code = code;
        this.title = title;
        this.publicationPeriod=publicationPeriod;
        this.yearOfPublication = yearOfPublication;
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
