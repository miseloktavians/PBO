package Pertemuan_09.Project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PilatesStudio {

    public static void header() {
        System.out.println("\n=== PILATES STUDIO MANAGEMENT ===");
    }

    // Method untuk menghitung total biaya setelah potongan diskon Member / Non-Member
    public static double hitungTotal(int sesi, double harga, String status) {
        double total = sesi * harga; // Variabel lokal primitif (tersimpan di Stack Memory)

        if (status.equalsIgnoreCase("Member")) {
            System.out.println("Diskon Member 15% diterapkan.");
            total = total - (total * 0.15); // Diskon 15% khusus Member
        } else if (total >= 500000) {
            System.out.println("Diskon Non-Member 10% diterapkan.");
            total = total - (total * 0.10); // Diskon 10% untuk Non-Member jika belanja >= 500rb
        }
        return total;
    }

    // POLYMORPHISM: Parameter bertipe Superclass (Pengajar[]) sehingga bisa menerima array InstrukturMat maupun InstrukturReformer
    public static void cetakJadwal(Pengajar[] daftarJadwal) {
        for (int i = 0; i < daftarJadwal.length; i++) {
            daftarJadwal[i].tampilkanInfoJadwal(i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Inisialisasi array objek dari Subclass InstrukturMat (tersimpan di Heap Memory)
        InstrukturMat[] jadwalMat = {
            new InstrukturMat("Sendry", "Senin", "08:00"),
            new InstrukturMat("Bella", "Rabu", "13:00"),
            new InstrukturMat("Chila", "Jumat", "16:00")
        };

        // Inisialisasi array objek dari Subclass InstrukturReformer
        InstrukturReformer[] jadwalReformer = {
            new InstrukturReformer("Sendry", "Senin", "10:00"),
            new InstrukturReformer("Bella", "Rabu", "15:00"),
            new InstrukturReformer("Chila", "Jumat", "18:00")
        };

        // Array untuk menyimpan data member terdaftar & riwayat transaksi booking
        Member[] dataMember = new Member[50];
        int totalMember = 0;

        Member[] dataBooking = new Member[50];
        int totalBooking = 0;

        // Perulangan utama menu aplikasi
        while (true) {
            // EXCEPTION HANDLING: Menangkap error jika user salah memasukkan huruf saat diminta angka
            try {
                header();
                System.out.println("1. Registrasi Member Baru");
                System.out.println("2. Booking Kelas");
                System.out.println("3. Lihat Member & Riwayat Booking");
                System.out.println("4. Cek Sisa Kuota Kelas");
                System.out.println("5. Batalkan Booking");
                System.out.println("6. Laporan Pendapatan Studio");
                System.out.println("7. Keluar");
                System.out.print("Pilih menu: ");

                int menu = scan.nextInt();

                if (menu == 1) {
                    // MENU 1: REGISTRASI MEMBER BARU
                    scan.nextLine(); // Membersihkan sisa karakter Enter
                    System.out.print("\nMasukkan Nama Member: ");
                    String nama = scan.nextLine();
                    System.out.print("Masukkan No. Telepon: ");
                    String noTelp = scan.nextLine();

                    // Membuat objek Member menggunakan Constructor Overloading 1
                    dataMember[totalMember] = new Member(nama, noTelp, "Member");
                    totalMember++;
                    System.out.println("\nMember " + nama + " berhasil didaftarkan!");

                } else if (menu == 2) {
                    // MENU 2: BOOKING KELAS PILATES
                    scan.nextLine();
                    System.out.print("\nNama Pelanggan: ");
                    String nama = scan.nextLine();

                    // Mengecek apakah nama pelanggan sudah terdaftar sebagai Member
                    boolean isMember = false;
                    for (int i = 0; i < totalMember; i++) {
                        if (dataMember[i].getNama().equalsIgnoreCase(nama)) {
                            isMember = true;
                            break;
                        }
                    }

                    String status = isMember ? "Member" : "Non-Member";
                    System.out.println("Status Pelanggan: " + status);

                    System.out.println("\nPilih Jenis Kelas:");
                    System.out.println("1. Mat Pilates (Rp 150.000)");
                    System.out.println("2. Reformer Pilates (Rp 250.000)");
                    System.out.print("Pilihan (1/2): ");
                    int pilihKelas = scan.nextInt();

                    String kelas = "";
                    Pengajar[] jadwalDipilih = null; // Referensi bertipe Superclass (Polymorphism)

                    if (pilihKelas == 1) {
                        kelas = jadwalMat[0].getJenisKelas();
                        jadwalDipilih = jadwalMat; // Diisi objek Subclass InstrukturMat
                    } else if (pilihKelas == 2) {
                        kelas = jadwalReformer[0].getJenisKelas();
                        jadwalDipilih = jadwalReformer; // Diisi objek Subclass InstrukturReformer
                    } else {
                        System.out.println("\nPilihan tidak ada.");
                        continue;
                    }

                    System.out.println("\n=== JADWAL & INSTRUKTUR (" + kelas.toUpperCase() + ") ===");
                    System.out.println("Fasilitas Kelas: " + jadwalDipilih[0].getFasilitas());
                    cetakJadwal(jadwalDipilih);

                    System.out.print("Pilih Hari (1-3): ");
                    int hari = scan.nextInt();

                    if (hari < 1 || hari > 3) {
                        System.out.println("\nPilihan hari salah.");
                        continue;
                    }

                    Pengajar pengajarTerpilih = jadwalDipilih[hari - 1];

                    if (pengajarTerpilih.getKuota() <= 0) {
                        System.out.println("\nKelas sudah penuh!");
                        continue;
                    }

                    String jadwalStr = pengajarTerpilih.getHari() + " - " + pengajarTerpilih.getJam();
                    String instruktur = pengajarTerpilih.getNamaPengajar();

                    System.out.println("Instruktur yang mengajar: Coach " + instruktur);
                    System.out.print("Masukkan Jumlah Sesi: ");
                    int sesi = scan.nextInt();

                    // Validasi jumlah sesi tidak boleh <= 0 atau melebihi sisa kuota
                    if (sesi <= 0 || sesi > pengajarTerpilih.getKuota()) {
                        System.out.println("\nJumlah sesi tidak valid atau melebihi kuota.");
                    } else {
                        pengajarTerpilih.kurangiKuota(sesi); // Mengurangi kuota pada objek Pengajar

                        System.out.println();
                        double totalBayar = hitungTotal(sesi, pengajarTerpilih.getHargaKelas(), status);

                        // Menyimpan transaksi ke array dataBooking menggunakan Constructor Overloading 2
                        Member m = new Member(nama, status, kelas, jadwalStr, instruktur, sesi, totalBayar);
                        dataBooking[totalBooking] = m;
                        totalBooking++;

                        // Mencetak struk bukti reservasi
                        System.out.println("\n================================");
                        System.out.println("       BUKTI RESERVASI");
                        System.out.println("================================");
                        System.out.println("Nama       : " + m.getNama());
                        System.out.println("Status     : " + m.getStatusMember());
                        System.out.println("Kelas      : " + m.getKelas());
                        System.out.println("Fasilitas  : " + pengajarTerpilih.getFasilitas());
                        System.out.println("Jadwal     : " + m.getJadwal());
                        System.out.println("Instruktur : Coach " + m.getPengajar());
                        System.out.println("Sesi       : " + m.getSesi());
                        System.out.println("Total      : Rp " + (int) m.getTotalBayar());
                        System.out.println("================================");
                    }

                } else if (menu == 3) {
                    // MENU 3: MELIHAT DAFTAR MEMBER & RIWAYAT BOOKING
                    System.out.println("\n=== DAFTAR MEMBER TERDAFTAR ===");
                    if (totalMember == 0) {
                        System.out.println("Belum ada member.");
                    } else {
                        for (int i = 0; i < totalMember; i++) {
                            System.out.println((i + 1) + ". " + dataMember[i].getNama() + " (" + dataMember[i].getNoTelp() + ")");
                        }
                    }

                    System.out.println("\n=== RIWAYAT BOOKING ===");
                    if (totalBooking == 0) {
                        System.out.println("Belum ada booking.");
                    } else {
                        for (int i = 0; i < totalBooking; i++) {
                            System.out.println((i + 1) + ". " + dataBooking[i].getNama() + " [" + dataBooking[i].getStatusMember() + "] | "
                                    + dataBooking[i].getKelas() + " | " + dataBooking[i].getJadwal()
                                    + " (" + dataBooking[i].getSesi() + " sesi - Coach " + dataBooking[i].getPengajar() + ")");
                        }
                    }

                } else if (menu == 4) {
                    // MENU 4: CEK SISA KUOTA & FASILITAS MASING-MASING KELAS
                    System.out.println("\n=== KUOTA MAT PILATES ===");
                    System.out.println("Fasilitas: " + jadwalMat[0].getFasilitas());
                    cetakJadwal(jadwalMat);

                    System.out.println("\n=== KUOTA REFORMER PILATES ===");
                    System.out.println("Fasilitas: " + jadwalReformer[0].getFasilitas());
                    cetakJadwal(jadwalReformer);

                } else if (menu == 5) {
                    // MENU 5: PEMBATALAN BOOKING & PENGEMBALIAN KUOTA
                    System.out.println("\n=== BATALKAN BOOKING ===");
                    if (totalBooking == 0) {
                        System.out.println("Belum ada data booking untuk dibatalkan.");
                    } else {
                        for (int i = 0; i < totalBooking; i++) {
                            System.out.println((i + 1) + ". " + dataBooking[i].getNama() + " | "
                                    + dataBooking[i].getKelas() + " | " + dataBooking[i].getJadwal()
                                    + " (" + dataBooking[i].getSesi() + " sesi)");
                        }
                        System.out.print("Pilih nomor booking yang ingin dibatalkan (0 untuk kembali): ");
                        int pilihBatal = scan.nextInt();

                        if (pilihBatal > 0 && pilihBatal <= totalBooking) {
                            Member batal = dataBooking[pilihBatal - 1];
                            // Menentukan array jadwal mana yang kuotanya harus dikembalikan
                            Pengajar[] targetList = batal.getKelas().equals("Mat Pilates") ? jadwalMat : jadwalReformer;

                            // Mencari jadwal yang cocok lalu mengembalikan kuota lewat tambahKuota()
                            for (Pengajar p : targetList) {
                                String jadwalObjek = p.getHari() + " - " + p.getJam();
                                if (jadwalObjek.equals(batal.getJadwal())) {
                                    p.tambahKuota(batal.getSesi());
                                    break;
                                }
                            }

                            // Menghapus data booking dari array dengan menggeser elemen di belakangnya
                            for (int i = pilihBatal - 1; i < totalBooking - 1; i++) {
                                dataBooking[i] = dataBooking[i + 1];
                            }
                            dataBooking[totalBooking - 1] = null;
                            totalBooking--;

                            System.out.println("\nBooking atas nama " + batal.getNama() + " berhasil dibatalkan & kuota telah dikembalikan!");
                        } else if (pilihBatal != 0) {
                            System.out.println("\nNomor booking tidak valid.");
                        }
                    }

                } else if (menu == 6) {
                    // MENU 6: LAPORAN PENDAPATAN STUDIO
                    System.out.println("\n=== LAPORAN PENDAPATAN STUDIO ===");
                    int sesiMat = 0, sesiReformer = 0;
                    double totalPemasukan = 0;

                    // Menjumlahkan sesi tiap jenis kelas dan total pemasukan dari seluruh transaksi aktif
                    for (int i = 0; i < totalBooking; i++) {
                        if (dataBooking[i].getKelas().equals("Mat Pilates")) {
                            sesiMat += dataBooking[i].getSesi();
                        } else {
                            sesiReformer += dataBooking[i].getSesi();
                        }
                        totalPemasukan += dataBooking[i].getTotalBayar();
                    }

                    System.out.println("Total Transaksi Aktif : " + totalBooking + " reservasi");
                    System.out.println("Terjual Mat Pilates   : " + sesiMat + " sesi");
                    System.out.println("Terjual Reformer      : " + sesiReformer + " sesi");
                    System.out.println("Total Pemasukan       : Rp " + (int) totalPemasukan);

                } else if (menu == 7) {
                    // MENU 7: KELUAR DARI PROGRAM
                    System.out.println("\nTerima kasih.");
                    break;

                } else {
                    System.out.println("\nPilihan tidak valid.");
                }

            } catch (InputMismatchException e) {
                // Menangani kesalahan input jika user mengetik teks/simbol pada input angka
                System.out.println("\n[Error] Input harus berupa angka, Silakan coba lagi.");
                scan.nextLine(); // Membersihkan input salah dari buffer Scanner agar tidak looping error
            }
        }

        scan.close();
    }
}