package com.enigma.enigpus_livecode.utility;

import com.enigma.enigpus_livecode.entity.Books;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utility {
//    private static final Path bookPath = Path.of("enigpus");

    public static String inputUtil(String info) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("%s : ", info);
            String result = scanner.nextLine();
            if (result.isEmpty() || result.isBlank()) {
                System.out.println("Tidak boleh kosong, wajib diisi!\n");
                continue;
            }
            return result;
        }
    }

    public static int inputIntUtil(String info) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("%s : ", info);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Tidak boleh kosong dan wajib inputan angka!\n");
                continue;
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    public static String novelCode(List<Books> bookLists, Integer year) {
        int lines = 0;

        int size = bookLists.size();
        System.out.println("boolistsize" + size);

        if (bookLists.isEmpty()) {
            lines = 1;
        } else {
            lines = bookLists.size() + 1;
        }

        String formattedCode = String.format("%s-A-%d", year, lines);

        return formattedCode;
    }

    public static String magazineCode(List<Books> bookLists, Integer year) {
        int lines = 0;

        int size = bookLists.size();
        System.out.println("boolistsize" + size);

        if (bookLists.isEmpty()) {
            lines = 1;
        } else {
            lines = bookLists.size() + 1;
        }

        String formattedCode = String.format("%s-B-%d", year, lines);

        return formattedCode;
    }


}
