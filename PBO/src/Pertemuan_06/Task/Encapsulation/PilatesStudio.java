package Pertemuan_06.Task.Encapsulation;

import java.util.Scanner;

// Kelas Model Member (Penerapan Encapsulation)
class Member {
    private String nama;
    private String statusMember;
    private String kelas;
    private String jadwal;
    private int sesi;

    public Member(String nama, String statusMember, String kelas, String jadwal, int sesi) {
        this.nama = nama;
        this.statusMember = statusMember;
        this.kelas = kelas;
        this.jadwal = jadwal;
        this.sesi = sesi;
    }

    // Getter
    public String getNama() { return nama; }
    public String getStatusMember() { return statusMember; }
    public String getKelas() { return kelas; }
    public String getJadwal() { return jadwal; }
    public int getSesi() { return sesi; }

    // Setter
    public void setNama(String nama) { this.nama = nama; }
    public void setStatusMember(String statusMember) { this.statusMember = statusMember; }
    public void setKelas(String kelas) { this.kelas = kelas; }
    public void setJadwal(String jadwal) { this.jadwal = jadwal; }
    public void setSesi(int sesi) { this.sesi = sesi; }
}

public class PilatesStudio {

    public static void tampilHeader() {
        System.out.println("\n========================================");
        System.out.println("        RESERVASI STUDIO PILATES        ");
        System.out.println("========================================");
    }

    public static double hitungBayar(int sesi, double harga, String statusMember) {
        double total = sesi * harga;

        if (statusMember.equalsIgnoreCase("VIP")) {
            System.out.println("-> Benefit VIP: Diskon 15% Diterapkan");
            total -= (total * 0.15);
        } else if (total >= 500000) {
            System.out.println("-> Promo Non-Member: Diskon 10% (Total >= Rp 500.000)");
            total -= (total * 0.10);
        }

        return total;
    }

    public static void tampilJadwal(int[] kuota, int maxKuota) {
        String[] daftarHari = {"1. Senin 08:00", "2. Rabu 13:00", "3. Jumat 16:00"};
        for (int i = 0; i < daftarHari.length; i++) {
            if (kuota[i] <= 0) {
                System.out.println(daftarHari[i] + " [FULL]");
            } else {
                System.out.println(daftarHari[i] + " (Sisa tempat: " + kuota[i] + "/" + maxKuota + ")");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] kuotaMat = {6, 6, 6};
        int[] kuotaReformer = {4, 4, 4};

        while (true) {
            tampilHeader();
            System.out.println("1. Reservasi Kelas");
            System.out.println("2. Lihat Jadwal Kelas");
            System.out.println("3. Keluar");
            System.out.print("Pilih Menu (1-3): ");
            int menu = in.nextInt();

            if (menu == 1) {
                in.nextLine(); // clear buffer
                System.out.print("\nNama Pelanggan: ");
                String nama = in.nextLine();

                System.out.println("\nTipe Kedatangan:");
                System.out.println("1. Member VIP (Diskon 15% + Poin)");
                System.out.println("2. Non-Member / Drop-in");
                System.out.print("Pilih (1/2): ");
                int tipe = in.nextInt();
                String statusMember = (tipe == 1) ? "VIP" : "Non-Member";

                System.out.println("\nPilih Jenis Kelas:");
                System.out.println("1. Mat Pilates (Rp 150.000) - Max 6 Orang");
                System.out.println("2. Reformer Pilates (Rp 250.000) - Max 4 Orang");
                System.out.print("Pilih (1/2): ");
                int pilihKelas = in.nextInt();

                String kelas;
                double harga;
                int[] kuotaDipilih;
                int maxKapasitas;

                if (pilihKelas == 1) {
                    kelas = "Mat Pilates";
                    harga = 150000;
                    kuotaDipilih = kuotaMat;
                    maxKapasitas = 6;
                } else if (pilihKelas == 2) {
                    kelas = "Reformer Pilates";
                    harga = 250000;
                    kuotaDipilih = kuotaReformer;
                    maxKapasitas = 4;
                } else {
                    System.out.println("Pilihan kelas tidak valid!");
                    continue;
                }

                System.out.println("\n--- Jadwal Tersedia ---");
                tampilJadwal(kuotaDipilih, maxKapasitas);
                System.out.print("Pilih Hari (1-3): ");
                int hari = in.nextInt();

                if (hari < 1 || hari > 3) {
                    System.out.println("Pilihan hari salah!");
                    continue;
                }

                int indexJadwal = hari - 1;
                if (kuotaDipilih[indexJadwal] <= 0) {
                    System.out.println("Maaf, jadwal ini sudah penuh!");
                    continue;
                }

                String[] opsiJadwal = {"Senin - 08:00", "Rabu - 13:00", "Jumat - 16:00"};
                String jadwal = opsiJadwal[indexJadwal];

                System.out.print("Jumlah Sesi: ");
                int sesi = in.nextInt();

                if (sesi <= 0) {
                    System.out.println("Jumlah sesi minimal 1!");
                    continue;
                } else if (sesi > kuotaDipilih[indexJadwal]) {
                    System.out.println("Sisa tempat tidak mencukupi!");
                    continue;
                } else {
                    // Update kuota
                    kuotaDipilih[indexJadwal] -= sesi;
                }

                // Buat Objek Member
                Member m = new Member(nama, statusMember, kelas, jadwal, sesi);

                double totalBayar = hitungBayar(m.getSesi(), harga, m.getStatusMember());
                int poinReward = m.getStatusMember().equals("VIP") ? m.getSesi() * 10 : 0;

                System.out.println("\n========================================");
                System.out.println("            BUKTI RESERVASI             ");
                System.out.println("========================================");
                System.out.println("Nama   : " + m.getNama());
                System.out.println("Status : " + m.getStatusMember());
                System.out.println("Kelas  : " + m.getKelas());
                System.out.println("Jadwal : " + m.getJadwal());
                System.out.println("Sesi   : " + m.getSesi());
                System.out.printf("Total  : Rp %.0f\n", totalBayar);
                if (poinReward > 0) {
                    System.out.println("Bonus  : " + poinReward + " Poin Member VIP");
                }
                System.out.println("========================================");

            } else if (menu == 2) {
                System.out.println("\n--- KUOTA MAT PILATES ---");
                tampilJadwal(kuotaMat, 6);

                System.out.println("\n--- KUOTA REFORMER PILATES ---");
                tampilJadwal(kuotaReformer, 4);

            } else if (menu == 3) {
                System.out.println("\nTerima kasih telah berkunjung ke Studio Pilates kami");
                break;
            } else {
                System.out.println("Pilihan menu tidak tersedia!");
            }
        }

        in.close();
    }
}