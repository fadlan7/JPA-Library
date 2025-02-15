package com.enigma.enigpus_livecode.view;

import com.enigma.enigpus_livecode.entity.Books;
import com.enigma.enigpus_livecode.service.InventoryService;
import com.enigma.enigpus_livecode.utility.Utility;

import java.util.List;

public class EnigpusView {
    private final InventoryService inventoryService;

    public EnigpusView(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void run() {
        showMainMenu();
    }

    private void showMainMenu() {
        while (true) {
            System.out.println("-".repeat(100));
            System.out.println("Main Menu");
            System.out.println("-".repeat(100));
            System.out.println("""
                    1. Tambah Novel
                    2. Tambah Majalah
                    3. Tampilkan Semua Buku
                    4. Cari Buku Berdasarkan Judul
                    5. Cari Buku Berdasarkan Kode
                    6. Hapus Buku
                    7. Update Buku
                    X. Keluar
                    """);
            System.out.println("-".repeat(100));
            String opt = Utility.inputUtil("Pilih Menu");
            switch (opt) {
                case "1" -> {
                    addNovelView();
                }
                case "2" -> {
                    addMagazineView();
                }
                case "3" -> {
                    showAllBook();
                }
                case "4" -> {
                    findBookByTitle();
                }
                case "5" -> {
                    findBookByCode();
                }
                case "6" -> {
                    deleteBook();
                }
                case "7" -> {
                    updateBook();
                }
                case "x", "X" -> {
                    return;
                }
                default -> {
                    System.out.println("Tidak ada pilihan menu itu!");
                }
            }
            System.out.println();
        }
    }

    private void addNovelView() {
        List<Books> books = inventoryService.getAllBook();

        String title = Utility.inputUtil("Input Judul");
        String publisher = Utility.inputUtil("Input Penerbit");
        Integer yearOfPublish = Utility.inputIntUtil("Input Tahun Terbit");
        String author = Utility.inputUtil("Input Penulis");

        String formattedCode = Utility.novelCode(books, yearOfPublish);

        Books novel = new Books(formattedCode, title, publisher, yearOfPublish, author);
        inventoryService.addBook(novel);
    }

    private void addMagazineView() {
        List<Books> books = inventoryService.getAllBook();
        String publicationPeriod;

        String title = Utility.inputUtil("Input Judul");
//        String publicationPeriod = Utility.inputUtil("Input Periode Terbit (mingguan atau bulanan)");
        Integer yearOfPublish = Utility.inputIntUtil("Input Tahun Terbit");

        do {
            publicationPeriod = Utility.inputUtil("Input Periode Terbit (mingguan atau bulanan)");
        }while(!(publicationPeriod.toLowerCase().equals("mingguan") || publicationPeriod.toLowerCase().equals("bulanan")));

        String formattedCode = Utility.magazineCode(books, yearOfPublish);

        Books novel = new Books(formattedCode, title, publicationPeriod, yearOfPublish);
        inventoryService.addBook(novel);
    }

    private void showAllBook() {
        List<Books> books = inventoryService.getAllBook();
        if (books != null && !books.isEmpty()) {
            System.out.println("-".repeat(100));
            String format = String.format("%-20s %-20s %-20s %-20s %-20s %-20s", "Kode", "Judul", "Penerbit", "Tahun Terbit", "Penulis", "Periode Terbit");
            System.out.println(format);
            for (Books book : books) {
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
        } else {
            System.out.println("Data Kosong");
        }
        System.out.println("-".repeat(100));
    }

    private void findBookByTitle() {
        String bookTitle = Utility.inputUtil("Masukan Judul Buku Yang Ingin Dicari");
        inventoryService.findBookByTitle(bookTitle);
    }

    private void findBookByCode() {
        String bookCode = Utility.inputUtil("Masukan Kode Buku Yang Ingin Dicari");
        inventoryService.findBookByCode(bookCode);
    }

    private void deleteBook() {
        String bookCode = Utility.inputUtil("Masukan Kode Buku Yang Ingin Dihapus");
        boolean deleted = inventoryService.deleteBookByCode(bookCode);

        if (deleted) {
            System.out.println("Buku dengan Kode " + bookCode + " berhasil dihapus.");
        } else {
            System.out.println("Buku dengan Kode " + bookCode + " tidak ditemukan.");
        }
    }

    private void updateBook(){
//        List<Books> books = inventoryService.getAllBook();
//
//        String bookCode = Utility.inputUtil("Masukan Kode Buku Yang Ingin Diedit");
//
//        inventoryService.updateBook(bookCode);
        System.out.println("Fitur belum selesai");
    }
}
