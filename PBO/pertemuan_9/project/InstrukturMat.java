package pertemuan_9.project;

// HIERARCHICAL INHERITANCE: Subclass pertama yang mewarisi kelas Pengajar
public class InstrukturMat extends Pengajar {
    private String jenisKelas = "Mat Pilates";

    // Constructor Subclass
    public InstrukturMat(String namaPengajar, String hari, String jam) {
        super(namaPengajar, hari, jam, 6, 150000);
    }

    public String getJenisKelas() {
        return jenisKelas;
    }

    // POLYMORPHISM (Method Overriding): Mengubah isi method getFasilitas() khusus untuk Mat Pilates
    @Override
    public String getFasilitas() {
        return "Matras Premium, Resistance Band, Yoga Block";
    }
}