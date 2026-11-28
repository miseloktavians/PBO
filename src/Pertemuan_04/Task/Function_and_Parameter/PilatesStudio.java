package Pertemuan_04.Task.Function_and_Parameter;

import java.util.Scanner; // Import library untuk input data dari pengguna

public class PilatesStudio {

    // Function Non-Returning Value (Void)
    // Method tanpa nilai kembalian untuk menampilkan header program
    public static void tampilHeader() {
        System.out.println("=== RESERVASI STUDIO PILATES ===");
    }

    // Function Returning Value & Parameter
    // Method dengan parameter (sesi, harga) dan mengembalikan nilai total bayar
    public static double hitungBayar(int sesi, double harga) {
        // Expression / Operasi Aritmatika
        double total = sesi * harga;

        // Control Statement (If-Else)
        // Mengecek apakah total pembelian mendapatkan diskon
        if (total >= 500000) {
            total = total - (total * 0.1); // Diskon 10% jika total >= 500rb
        }

        return total; // Mengembalikan nilai hasil perhitungan
    }

    // MAIN METHOD (Program Utama)
    public static void main(String[] args) {
        // Inisialisasi Scanner, Tipe Data, Variabel
        Scanner in = new Scanner(System.in);

        // Memanggil fungsi void header
        tampilHeader();

        // Input nama member (Tipe data String)
        System.out.print("Nama Member: ");
        String nama = in.nextLine();

        // Menampilkan pilihan kelas
        System.out.println("Pilih Kelas: 1. Mat (150k) | 2. Reformer (250k)");
        System.out.print("Pilih (1/2): ");
        int pilih = in.nextInt(); // Tipe data Integer

        // Deklarasi variabel penampung
        String kelas = "";
        double harga = 0; // Tipe data Double

        // Control Statement (Switch-Case)
        // Menentukan kelas dan harga berdasarkan pilihan
        switch (pilih) {
            case 1:
                kelas = "Mat Pilates";
                harga = 150000;
                break;
            case 2:
                kelas = "Reformer Pilates";
                harga = 250000;
                break;
            default:
                System.out.println("Pilihan salah!");
                in.close();
                return;
        }

        // Input jumlah sesi
        System.out.print("Jumlah Sesi: ");
        int sesi = in.nextInt();

        // Memanggil function hitungBayar dengan argumen/parameter
        double bayar = hitungBayar(sesi, harga);

        // Method Math bawaan Java (Math.max) & Ekspresi Durasi
        int durasi = Math.max(sesi * 60, 60);

        // Display Output Hasil Reservasi
        System.out.println("\nBUKTI RESERVASI");
        System.out.println("Nama   : " + nama);
        System.out.println("Kelas  : " + kelas);
        System.out.println("Durasi : " + sesi + " sesi (" + durasi + " menit)");
        System.out.println("Total  : Rp " + bayar);

        in.close(); // Menutup scanner
    }
}