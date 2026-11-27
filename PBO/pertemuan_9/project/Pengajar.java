package pertemuan_9.project;

// SUPERCLASS: Kelas induk yang menyimpan atribut dan method umum untuk semua jenis instruktur
public class Pengajar {
    // Access modifier 'protected' agar atribut ini bisa diwarisi dan diakses langsung oleh Subclass
    protected String namaPengajar;
    protected String hari;
    protected String jam;
    protected int kuota;
    protected int maxKapasitas;
    protected double hargaKelas;

    // Constructor Superclass untuk menginisialisasi data dasar jadwal & instruktur
    public Pengajar(String namaPengajar, String hari, String jam, int maxKapasitas, double hargaKelas) {
        this.namaPengajar = namaPengajar;
        this.hari = hari;
        this.jam = jam;
        this.kuota = maxKapasitas; // Awalnya sisa kuota sama dengan kapasitas maksimal
        this.maxKapasitas = maxKapasitas;
        this.hargaKelas = hargaKelas;
    }

    // Method Getter untuk mengambil nilai atribut
    public String getNamaPengajar() { return namaPengajar; }
    public String getHari() { return hari; }
    public String getJam() { return jam; }
    public int getKuota() { return kuota; }
    public double getHargaKelas() { return hargaKelas; }

    // Mengurangi sisa kuota ketika pelanggan berhasil melakukan booking
    public void kurangiKuota(int jumlahSesi) {
        this.kuota -= jumlahSesi;
    }

    // Mengembalikan sisa kuota ketika pelanggan membatalkan booking (Menu 5)
    public void tambahKuota(int jumlahSesi) {
        this.kuota += jumlahSesi;
    }

    // POLYMORPHISM: Method default yang nantinya akan di-Override oleh masing-masing Subclass
    public String getFasilitas() {
        return "Fasilitas standar studio";
    }

    // Menampilkan informasi lengkap satu baris jadwal beserta sisa kuotanya
    public void tampilkanInfoJadwal(int nomor) {
        System.out.println(nomor + ". " + hari + " (" + jam + ") | Instruktur: Coach " 
                + namaPengajar + " | Sisa Kuota: " + kuota + "/" + maxKapasitas);
    }
}