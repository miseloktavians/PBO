package Pertemuan_09.Versi_Keseluruhan_Project;

import java.util.InputMismatchException;
import java.util.Scanner;

class Pengajar {
    protected String namaPengajar;
    protected String hari;
    protected String jam;
    protected int kuota;
    protected int maxKapasitas;
    protected double hargaKelas;

    public Pengajar(String namaPengajar, String hari, String jam, int maxKapasitas, double hargaKelas) {
        this.namaPengajar = namaPengajar;
        this.hari = hari;
        this.jam = jam;
        this.kuota = maxKapasitas;
        this.maxKapasitas = maxKapasitas;
        this.hargaKelas = hargaKelas;
    }

    public String getNamaPengajar() { return namaPengajar; }
    public String getHari() { return hari; }
    public String getJam() { return jam; }
    public int getKuota() { return kuota; }
    public double getHargaKelas() { return hargaKelas; }

    public void kurangiKuota(int jumlahSesi) {
        this.kuota -= jumlahSesi;
    }

    public void tambahKuota(int jumlahSesi) {
        this.kuota += jumlahSesi;
    }

    public String getFasilitas() {
        return "Fasilitas standar studio";
    }

    public void tampilkanInfoJadwal(int nomor) {
        System.out.println(nomor + ". " + hari + " (" + jam + ") | Instruktur: Coach " 
                + namaPengajar + " | Sisa Kuota: " + kuota + "/" + maxKapasitas);
    }
}

class InstrukturMat extends Pengajar {
    private String jenisKelas = "Mat Pilates";

    public InstrukturMat(String namaPengajar, String hari, String jam) {
        super(namaPengajar, hari, jam, 6, 150000);
    }

    public String getJenisKelas() {
        return jenisKelas;
    }

    @Override
    public String getFasilitas() {
        return "Matras Premium, Resistance Band, Yoga Block";
    }
}

class InstrukturReformer extends Pengajar {
    private String jenisKelas = "Reformer Pilates";

    public InstrukturReformer(String namaPengajar, String hari, String jam) {
        super(namaPengajar, hari, jam, 4, 250000);
    }

    public String getJenisKelas() {
        return jenisKelas;
    }

    @Override
    public String getFasilitas() {
        return "Mesin Reformer, Reformer Box, Grip Socks";
    }
}

class Member {
    private String nama;
    private String noTelp;
    private String statusMember;
    private String kelas;
    private String jadwal;
    private String pengajar;
    private int sesi;
    private double totalBayar;

    public Member(String nama, String noTelp, String statusMember) {
        this.nama = nama;
        this.noTelp = noTelp;
        this.statusMember = statusMember;
        this.kelas = "-";
        this.jadwal = "-";
        this.pengajar = "-";
        this.sesi = 0;
        this.totalBayar = 0;
    }

    public Member(String nama, String statusMember, String kelas, String jadwal, String pengajar, int sesi, double totalBayar) {
        this.nama = nama;
        this.noTelp = "-";
        this.statusMember = statusMember;
        this.kelas = kelas;
        this.jadwal = jadwal;
        this.pengajar = pengajar;
        this.sesi = sesi;
        this.totalBayar = totalBayar;
    }

    public String getNama() { return nama; }
    public String getNoTelp() { return noTelp; }
    public String getStatusMember() { return statusMember; }
    public String getKelas() { return kelas; }
    public String getJadwal() { return jadwal; }
    public String getPengajar() { return pengajar; }
    public int getSesi() { return sesi; }
    public double getTotalBayar() { return totalBayar; }
}

public class PilatesStudio {

    public static void header() {
        System.out.println("\n=== PILATES STUDIO MANAGEMENT ===");
    }

    public static double hitungTotal(int sesi, double harga, String status) {
        double total = sesi * harga;

        if (status.equalsIgnoreCase("Member")) {
            System.out.println("Diskon Member 15% diterapkan.");
            total = total - (total * 0.15);
        } else if (total >= 500000) {
            System.out.println("Diskon Non-Member 10% diterapkan.");
            total = total - (total * 0.10);
        }
        return total;
    }

    public static void cetakJadwal(Pengajar[] daftarJadwal) {
        for (int i = 0; i < daftarJadwal.length; i++) {
            daftarJadwal[i].tampilkanInfoJadwal(i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        InstrukturMat[] jadwalMat = {
            new InstrukturMat("Sendry", "Senin", "08:00"),
            new InstrukturMat("Bella", "Rabu", "13:00"),
            new InstrukturMat("Chila", "Jumat", "16:00")
        };

        InstrukturReformer[] jadwalReformer = {
            new InstrukturReformer("Sendry", "Senin", "10:00"),
            new InstrukturReformer("Bella", "Rabu", "15:00"),
            new InstrukturReformer("Chila", "Jumat", "18:00")
        };

        Member[] dataMember = new Member[50];
        int totalMember = 0;

        Member[] dataBooking = new Member[50];
        int totalBooking = 0;

        while (true) {
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
                    scan.nextLine();
                    System.out.print("\nMasukkan Nama Member: ");
                    String nama = scan.nextLine();
                    System.out.print("Masukkan No. Telepon: ");
                    String noTelp = scan.nextLine();

                    dataMember[totalMember] = new Member(nama, noTelp, "Member");
                    totalMember++;
                    System.out.println("\nMember " + nama + " berhasil didaftarkan!");

                } else if (menu == 2) {
                    scan.nextLine();
                    System.out.print("\nNama Pelanggan: ");
                    String nama = scan.nextLine();

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
                    Pengajar[] jadwalDipilih = null;

                    if (pilihKelas == 1) {
                        kelas = jadwalMat[0].getJenisKelas();
                        jadwalDipilih = jadwalMat;
                    } else if (pilihKelas == 2) {
                        kelas = jadwalReformer[0].getJenisKelas();
                        jadwalDipilih = jadwalReformer;
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

                    if (sesi <= 0 || sesi > pengajarTerpilih.getKuota()) {
                        System.out.println("\nJumlah sesi tidak valid atau melebihi kuota.");
                    } else {
                        pengajarTerpilih.kurangiKuota(sesi);

                        System.out.println();
                        double totalBayar = hitungTotal(sesi, pengajarTerpilih.getHargaKelas(), status);

                        Member m = new Member(nama, status, kelas, jadwalStr, instruktur, sesi, totalBayar);
                        dataBooking[totalBooking] = m;
                        totalBooking++;

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
                    System.out.println("\n=== KUOTA MAT PILATES ===");
                    System.out.println("Fasilitas: " + jadwalMat[0].getFasilitas());
                    cetakJadwal(jadwalMat);

                    System.out.println("\n=== KUOTA REFORMER PILATES ===");
                    System.out.println("Fasilitas: " + jadwalReformer[0].getFasilitas());
                    cetakJadwal(jadwalReformer);

                } else if (menu == 5) {
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
                            Pengajar[] targetList = batal.getKelas().equals("Mat Pilates") ? jadwalMat : jadwalReformer;

                            for (Pengajar p : targetList) {
                                String jadwalObjek = p.getHari() + " - " + p.getJam();
                                if (jadwalObjek.equals(batal.getJadwal())) {
                                    p.tambahKuota(batal.getSesi());
                                    break;
                                }
                            }

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
                    System.out.println("\n=== LAPORAN PENDAPATAN STUDIO ===");
                    int sesiMat = 0, sesiReformer = 0;
                    double totalPemasukan = 0;

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
                    System.out.println("\nTerima kasih!");
                    break;

                } else {
                    System.out.println("\nPilihan tidak valid.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n[Error] Input harus berupa angka! Silakan coba lagi.");
                scan.nextLine();
            }
        }

        scan.close();
    }
}