package com.enigma.enigpus_livecode.service;

import com.enigma.enigpus_livecode.entity.Books;
import com.enigma.enigpus_livecode.entity.Novel;

import java.util.List;

public interface InventoryService {
    void addBook(Books book);
    void findBookByTitle(String title);
    void findBookByCode(String bookCode);
    boolean deleteBookByCode(String bookCode);
    List<Books> getAllBook();
}
