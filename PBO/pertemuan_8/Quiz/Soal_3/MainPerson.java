package pertemuan_8.Quiz.Soal_3;

public class MainPerson {
    public static void main(String[] args) {
    
    // Objek dari cabang Teacher
    Teacher dosen = new Teacher();
            dosen.setNama("Qori Halimatul Hidayah, S.Pd., M.Kom.");
            dosen.tampilkanIdentitas();
            dosen.mengajar();
            System.out.println("--------------------------------------------------------------");

    // Objek dari cabang bertingkat CollegeStudent
    CollegeStudent mhs = new CollegeStudent();
    mhs.setNama("Misel Oktaviani Putri");
    mhs.tampilkanIdentitas();
    mhs.belajar();
    mhs.infoMahasiswa();
}
}