package com.enigma.enigpus_livecode.service;

import com.enigma.enigpus_livecode.entity.Book;
import com.enigma.enigpus_livecode.entity.Books;
import com.enigma.enigpus_livecode.entity.Novel;
import com.enigma.enigpus_livecode.utility.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class InventoryServiceImpl implements InventoryService{

    @Override
    public void addBook(Books book) {
        List<Books> bookLists =getAllBook();
        bookLists.add(book);
        FileUtil.saveObject(bookLists);
    }

    @Override
    public List<Books> getAllBook() {
        Object object = FileUtil.readObject();

        if (object == null) {
            return new ArrayList<>();
        }

        return (List<Books>) object;
    }

    @Override
    public void searchBookByTitle() {

    }

    @Override
    public void searchBookByCode() {

    }

    @Override
    public void deleteBookByCode() {

    }
}
