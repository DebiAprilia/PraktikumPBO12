/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugasPBO12;

/**
 *
 * @author user
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemManajemenBuku {
    private static final String TEXT_FILE = "buku.txt";
    private static final String SERIAL_FILE = "buku.ser";
    private static List<Buku> bukuList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. Tambah Buku Baru dan Simpan ke File Teks");
            System.out.println("2. Simpan Objek Buku ke File (Serialisasi)");
            System.out.println("3. Tampilkan Daftar Buku dari File Teks");
            System.out.println("4. Tampilkan Daftar Buku dari File Serial");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();  

            switch (pilihan) {
                case 1 -> tambahBukuDanSimpan(scanner);
                case 2 -> simpanKeFileSerial();
                case 3 -> tampilkanBukuDariFileTeks();
                case 4 -> tampilkanBukuDariFileSerial();
                case 5 -> {
                    System.out.println("Keluar dari sistem.");
                    scanner.close();
                    return;
                } 
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void tambahBukuDanSimpan(Scanner scanner) {
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan pengarang: ");
        String pengarang = scanner.nextLine();
        System.out.print("Masukkan tahun terbit: ");
        int tahunTerbit = scanner.nextInt();
        scanner.nextLine();  // Konsumsi newline

        Buku buku = new Buku(judul, pengarang, tahunTerbit);
        bukuList.add(buku);
        System.out.println("Buku berhasil ditambahkan.");

        // Simpan ke file teks
        try (FileWriter writer = new FileWriter(TEXT_FILE, true)) {
            writer.write(buku.toString() + "\n");
            System.out.println("Data buku berhasil disimpan ke file teks.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan ke file teks.");
            e.printStackTrace();
        }
    }

    private static void simpanKeFileSerial() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SERIAL_FILE))) {
            oos.writeObject(bukuList);
            System.out.println("Objek buku berhasil disimpan ke file serial.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan ke file serial.");
            e.printStackTrace();
        }
    }

    private static void tampilkanBukuDariFileTeks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(TEXT_FILE))) {
            String line;
            System.out.println("Daftar Buku dari File Teks: ");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca dari file teks.");
            e.printStackTrace();
        }
    }

    private static void tampilkanBukuDariFileSerial() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SERIAL_FILE))) {
            List<Buku> deserializedBukuList = (List<Buku>) ois.readObject();
            System.out.println("Daftar Buku dari File Serial: ");
            for (Buku buku : deserializedBukuList) {
                System.out.println(buku);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Terjadi kesalahan saat membaca dari file serial.");
            e.printStackTrace();
        }
    }
}
