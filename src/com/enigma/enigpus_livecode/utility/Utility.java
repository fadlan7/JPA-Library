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

    public static String novelCode(Integer year) {
        int lines = 0;


        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(FileUtil.bookPath)))) {

//            while ((reader.readLine() != null)) {
//                if (reader.readLine() == null) {
//                    lines = 1;
//                } else {
//                    lines++;
//                }
//            }

//            if (reader.readLine() == null) {
//                lines += 1;
//            } else {
            while (reader.readLine() != null) lines++;
//            }

            reader.close();
            System.out.println(lines);
        } catch (FileNotFoundException e) {
//            lines =1;
            File emptyFile = new File("enigpus");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String formattedCode = String.format("%s-A-%d", year, lines);

        return formattedCode;
    }

    public static String magazineCode(Integer year) {
        int lines = 0;


        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(FileUtil.bookPath)))) {

//            while ((reader.readLine() != null)) {
//                if (reader.readLine() == null) {
//                    lines = 1;
//                } else {
//                    lines++;
//                }
//            }

//            if (reader.readLine() == null) {
//                lines += 1;
//            } else {
            while (reader.readLine() != null) lines++;
//            }

            reader.close();
            System.out.println(lines);
        } catch (FileNotFoundException e) {
//            lines =1;
            File emptyFile = new File("enigpus");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String formattedCode = String.format("%s-B-%d", year, lines);

        return formattedCode;
    }


}
