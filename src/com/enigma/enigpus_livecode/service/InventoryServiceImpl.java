package com.enigma.enigpus_livecode.service;

import com.enigma.enigpus_livecode.entity.Books;
import com.enigma.enigpus_livecode.utility.FileUtil;

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
    public boolean deleteBookByCode(String bookCode) {
        List<Books> books = getAllBook();
        boolean deleted = false;

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getCode().equals(bookCode)) {
                books.remove(i);
                deleted = true;
                break;
            }
        }

        if (deleted) {
            FileUtil.saveObject(books);
        }

        return deleted;
    }
}
