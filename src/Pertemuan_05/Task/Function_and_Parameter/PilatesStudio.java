package Pertemuan_05.Task.Function_and_Parameter;

import java.util.Scanner;

public class PilatesStudio {

    public static void tampilHeader() {
        System.out.println("=== RESERVASI STUDIO PILATES ===");
    }

    public static double hitungBayar(int sesi, double harga) {
        double total = sesi * harga;
        if (total >= 500000) {
            total = total - (total * 0.1);
        }
        return total;
    }

    public static void tampilJadwal(int[] kuota, int maxKuota) {
        System.out.println("\n=== JADWAL PILATES ===");
        String[] daftarHari = {"1. Senin 08:00", "2. Rabu 13:00", "3. Jumat 16:00"};

        for (int i = 0; i < daftarHari.length; i++) {
            if (kuota[i] <= 0) {
                System.out.println(daftarHari[i] + " [penuh]");
            } else {
                System.out.println(daftarHari[i] + " (Sisa: " + kuota[i] + "/" + maxKuota + " tempat)");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Kuota kelas: Mat Pilates (6 orang), Reformer Pilates (4 orang)
        int[] kuotaMat = {6, 6, 6};
        int[] kuotaReformer = {4, 4, 4};

        while (true) {
            tampilHeader();
            System.out.println("1. Reservasi Kelas");
            System.out.println("2. Lihat Jadwal Kelas");
            System.out.println("3. Keluar");
            System.out.print("Pilih Menu: ");
            int menu = in.nextInt();

            switch (menu) {
                case 1:
                    in.nextLine();
                    System.out.print("Nama Member: ");
                    String nama = in.nextLine();

                    System.out.println("Pilih Kelas:");
                    System.out.println("1. Mat Pilates (150k) Max 6 Orang");
                    System.out.println("2. Reformer Pilates (250k) Max 4 Orang");
                    System.out.print("Pilih (1/2): ");
                    int pilih = in.nextInt();

                    String kelas = "";
                    double harga = 0;
                    int[] kuotaDipilih;
                    int maxKapasitas = 0;

                    if (pilih == 1) {
                        kelas = "Mat Pilates";
                        harga = 150000;
                        kuotaDipilih = kuotaMat;
                        maxKapasitas = 6;
                    } else if (pilih == 2) {
                        kelas = "Reformer Pilates";
                        harga = 250000;
                        kuotaDipilih = kuotaReformer;
                        maxKapasitas = 4;
                    } else {
                        System.out.println("Pilihan Salah");
                        break;
                    }

                    tampilJadwal(kuotaDipilih, maxKapasitas);
                    System.out.print("Pilih Hari (1-3): ");
                    int hari = in.nextInt();

                    if (hari < 1 || hari > 3) {
                        System.out.println("Jadwal salah!");
                        break;
                    }

                    int indexJadwal = hari - 1;
                    if (kuotaDipilih[indexJadwal] <= 0) {
                        System.out.println("Maaf, kelas " + kelas + " pada jadwal tersebut sudah penuh");
                        break;
                    }

                    String jadwal = "";
                    if (hari == 1) jadwal = "Senin - 08:00";
                    else if (hari == 2) jadwal = "Rabu - 13:00";
                    else if (hari == 3) jadwal = "Jumat - 16:00";

                    System.out.print("Jumlah Sesi: ");
                    int sesi = in.nextInt();

                    if (sesi <= 0) {
                        System.out.println("Jumlah sesi tidak tersedia");
                    } else {
                        kuotaDipilih[indexJadwal]--;

                        double bayar = hitungBayar(sesi, harga);
                        System.out.println("BUKTI RESERVASI");
                        System.out.println("Nama   : " + nama);
                        System.out.println("Kelas  : " + kelas);
                        System.out.println("Jadwal : " + jadwal);
                        System.out.println("Sesi   : " + sesi);
                        System.out.println("Total  : Rp " + bayar + "\n");
                    }
                    break;

                case 2:
                    System.out.println("KUOTA MAT PILATES");
                    tampilJadwal(kuotaMat, 6);
                    System.out.println("KUOTA REFORMER PILATES");
                    tampilJadwal(kuotaReformer, 4);
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Terima kasih!");
                    in.close();
                    return;

                default:
                    System.out.println("Menu tidak tersedia");
            }
        }
    }
}