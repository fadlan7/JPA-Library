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
    public void findBookByTitle(String title) {
        List<Books> books = getAllBook();

        for (Books book : books) {
            if (book.getTitle().equals(title)) {
                String format = String.format("%-20s %-20s %-20s %-20s %-20s %-20s", "Kode", "Judul", "Penerbit", "Tahun Terbit", "Penulis", "Periode Terbit");
                System.out.println(format);

                String publisher = book.getPublisher();
                String author = book.getAuthor();
                String publicationPeriod = book.getPublicationPeriod();
                if (book.getPublicationPeriod() == null) {
                    publicationPeriod = "-";
                }

                if (book.getPublisher() == null && book.getAuthor() == null) {
                    publisher = "-";
                    author = "-";
                }

                System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", book.getCode(), book.getTitle(), publisher, book.getYearOfPublication(), author, publicationPeriod);

            }
//            else {
//                System.out.println("Buku tidak ditemukan");
//            }
        }
    }

    @Override
    public void findBookByCode(String bookCode) {
        List<Books> books = getAllBook();
        for (Books book : books) {
            if (book.getCode().equals(bookCode)) {
                String format = String.format("%-20s %-20s %-20s %-20s %-20s %-20s", "Kode", "Judul", "Penerbit", "Tahun Terbit", "Penulis", "Periode Terbit");
                System.out.println(format);

                String publisher = book.getPublisher();
                String author = book.getAuthor();
                String publicationPeriod = book.getPublicationPeriod();
                if (book.getPublicationPeriod() == null) {
                    publicationPeriod = "-";
                }

                if (book.getPublisher() == null && book.getAuthor() == null) {
                    publisher = "-";
                    author = "-";
                }

                System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", book.getCode(), book.getTitle(), publisher, book.getYearOfPublication(), author, publicationPeriod);

            }
        }
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
