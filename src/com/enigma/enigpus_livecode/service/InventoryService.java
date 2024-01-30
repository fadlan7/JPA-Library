package com.enigma.enigpus_livecode.service;

import com.enigma.enigpus_livecode.entity.Books;
import com.enigma.enigpus_livecode.entity.Novel;

import java.util.List;

public interface InventoryService {
    void addBook(Books book);
    void  searchBookByTitle();
    void searchBookByCode();
    void deleteBookByCode();
    List<Books> getAllBook();
}
