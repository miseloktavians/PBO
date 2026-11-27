package Inheritance;

//  (Gabungan Hierarchical + Multiple)
// Gabungan extends (Hierarchical) dan implements (Multiple).

class Pegawai {
    String nama = "Budi";
    void absen() {
        System.out.println("Nama Pegawai: " + nama);
    }
}

interface SkillBarista {
    void buatKopi();
}

// Anak 1: Kasir (cuma extends Pegawai)
class Kasir extends Pegawai {
    void tugasKasir() {
        System.out.println("Tugas: Melayani Pembayaran");
    }
}

// Anak 2: Barista (extends Pegawai + implements SkillBarista)
class Barista extends Pegawai implements SkillBarista {
    public void buatKopi() {
        System.out.println("Tugas: Meracik Kopi");
    }
}

public class MainHybrid {
    public static void main(String[] args) {
        Barista b = new Barista();
        b.absen();    // Dari class Pegawai
        b.buatKopi(); // Dari interface SkillBarista
    }
}