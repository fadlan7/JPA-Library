package com.enigma.enigpus_livecode.entity;

public class Magazine extends Book{
    private String code;
    private String title;
    private String publicationPeriod;
    private String yearOfPublication;

    public Magazine(String title, String publicationPeriod, String yearOfPublication) {
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

    public String getPublicationPeriod() {
        return publicationPeriod;
    }

    public void setPublicationPeriod(String publicationPeriod) {
        this.publicationPeriod = publicationPeriod;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(String yearOfPublication) {
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
