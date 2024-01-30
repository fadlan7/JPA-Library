package com.enigma.enigpus_livecode.view;

import com.enigma.enigpus_livecode.entity.Books;
import com.enigma.enigpus_livecode.entity.Novel;
import com.enigma.enigpus_livecode.service.InventoryService;
import com.enigma.enigpus_livecode.service.InventoryServiceImpl;
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
                case "x", "X" -> {
                    return;
                }
            }
            System.out.println();
        }
    }

    private void addNovelView() {
        String title = Utility.inputUtil("Input Judul");
        String publisher = Utility.inputUtil("Input Penerbit");
        String yearOfPublish = Utility.inputUtil("Input Tahun Terbit");
        String author = Utility.inputUtil("Input Penulis");

        String formattedCode = Utility.novelCode(yearOfPublish);

        System.out.println(formattedCode);
        Books novel = new Books(formattedCode, title, publisher, yearOfPublish, author);
        inventoryService.addBook(novel);
    }

    private void addMagazineView() {
        String title = Utility.inputUtil("Input Judul");
        String publicationPeriod = Utility.inputUtil("Input Periode Terbit (mingguan atau bulanan)");
        String yearOfPublish = Utility.inputUtil("Input Tahun Terbit");

        String formattedCode = Utility.magazineCode(yearOfPublish);

        System.out.println(formattedCode);
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


    private void saveMahasiswaView() {
        String name = Utility.inputUtil("Input Nama");
        int age = Utility.inputIntUtil("Input Umur");
        String major = Utility.inputUtil("Input Jurusan");
//        Mahasiswa mahasiswa = new Mahasiswa(name, age, major);
//        mahasiswaService.create(mahasiswa);
    }


    private void viewAllMahasiswa() {
//        List<Mahasiswa> mahasiswas = mahasiswaService.getAll();
//        if (mahasiswas != null && !mahasiswas.isEmpty()) {
//            System.out.println("-".repeat(100));
//            String format = String.format("%-10s %-30s %-10s %-30s","Id", "Nama", "Umur", "Jurusan");
//            System.out.println(format);
//            for (Mahasiswa mahasiswa : mahasiswas) {
//                System.out.printf("%-10s %-30s %-10s %-30s\n", mahasiswa.getId(), mahasiswa.getName(), mahasiswa.getAge(), mahasiswa.getMajor());
//            }
//        } else {
//            System.out.println("Data Kosong");
//        }
//        System.out.println("-".repeat(100));
    }

    private void deleteMahasiswa() {
//        int id = Utility.inputIntUtil("Enter Mahasiswa ID to delete");
//        boolean deleted = mahasiswaService.delete(id);
//
//        if (deleted) {
//            System.out.println("Mahasiswa with ID " + id + " deleted successfully.");
//        } else {
//            System.out.println("Mahasiswa with ID " + id + " not found.");
//        }
    }
}
