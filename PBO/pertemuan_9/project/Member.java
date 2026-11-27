package pertemuan_9.project;

// ENCAPSULATION: Semua atribut dibuat "private" agar terlindungi dan hanya diakses lewat Getter
public class Member {
    private String nama;
    private String noTelp;
    private String statusMember;
    private String kelas;
    private String jadwal;
    private String pengajar;
    private int sesi;
    private double totalBayar;

    // CONSTRUCTOR OVERLOADING 1: Digunakan saat registrasi member baru (Menu 1)
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

    // CONSTRUCTOR OVERLOADING 2: Digunakan saat menyimpan data transaksi booking (Menu 2)
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

    // Method Getter untuk membaca data atribut private
    public String getNama() { return nama; }
    public String getNoTelp() { return noTelp; }
    public String getStatusMember() { return statusMember; }
    public String getKelas() { return kelas; }
    public String getJadwal() { return jadwal; }
    public String getPengajar() { return pengajar; }
    public int getSesi() { return sesi; }
    public double getTotalBayar() { return totalBayar; }
}