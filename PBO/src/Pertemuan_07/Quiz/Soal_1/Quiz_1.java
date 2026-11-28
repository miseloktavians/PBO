package Pertemuan_07.Quiz.Soal_1;

// Soal 1 - Sistem Informasi Buku

import java.util.Scanner; 

class Buku {
    String judul, penulis;
    int tahunTerbit;

    public Buku(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    public void tampilan() {
        System.out.println("=== DATA BUKU ===");
        System.out.println("Judul        : " + judul);
        System.out.println("Penulis      : " + penulis);
        System.out.println("Tahun Terbit : " + tahunTerbit);
        System.out.println();
    }
}

public class Quiz_1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=== Buku 1 ===");
        System.out.print("Masukkan Judul : ");
        String judul1 = input.nextLine();
        System.out.print("Masukkan Penulis : ");
        String penulis1= input.nextLine();
        System.out.print("Masukkan Tahun Terbit : ");
        int tahunTerbit1 = input.nextInt();
        input.nextLine(); 

        System.out.println("=== Buku 2 ===");
        System.out.print("Masukkan Judul : ");
        String judul2 = input.nextLine();
        System.out.print("Masukkan Penulis : ");
        String penulis2 = input.nextLine();
        System.out.print("Masukkan Tahun Terbit : ");
        int tahunTerbit2 = input.nextInt();

        Buku buku1 = new Buku(judul1,penulis1,tahunTerbit1);
        Buku buku2 = new Buku(judul2,penulis2,tahunTerbit2);
        System.out.println(); 

        buku1.tampilan();
        buku2.tampilan();

        input.close();
    }
}