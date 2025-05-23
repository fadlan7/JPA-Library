package com.enigma.enigpus_livecode.service;

import com.enigma.enigpus_livecode.entity.Book;
import com.enigma.enigpus_livecode.entity.Books;
import java.util.List;

public interface InventoryService {
    void addBook(Books book);
    void findBookByTitle(String title);
    void findBookByCode(String bookCode);
    boolean deleteBookByCode(String bookCode);
    List<Books> getAllBook();
    void updateBook (String bookCode);
}
