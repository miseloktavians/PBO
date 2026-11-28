package Pertemuan_09.Project;

// HIERARCHICAL INHERITANCE: Subclass kedua yang juga mewarisi kelas Pengajar
public class InstrukturReformer extends Pengajar {
    private String jenisKelas = "Reformer Pilates";

    // Constructor Subclass
    public InstrukturReformer(String namaPengajar, String hari, String jam) {
        super(namaPengajar, hari, jam, 4, 250000);
    }

    public String getJenisKelas() {
        return jenisKelas;
    }

    // POLYMORPHISM (Method Overriding): Mengubah isi method getFasilitas() khusus untuk Reformer Pilates
    @Override
    public String getFasilitas() {
        return "Mesin Reformer, Reformer Box, Grip Socks";
    }
}