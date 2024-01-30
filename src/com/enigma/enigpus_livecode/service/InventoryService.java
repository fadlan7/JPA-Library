package com.enigma.enigpus_livecode.service;

public interface InventoryService {
    void addBook();
    void  searchBookByTitle();
    void searchBookByCode();
    void deleteBookByCode();
    void getAllBook();
}
