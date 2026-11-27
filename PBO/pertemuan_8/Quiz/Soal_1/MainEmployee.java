package pertemuan_8.Quiz.Soal_1;

public class MainEmployee {
    public static void main(String[] args) {
        Manager m = new Manager("Misel Oktaviani Putri", "Manager Operasional", 8000000, 1500000, 2500000);
        
        System.out.println("=== DATA KARYAWAN ===");
        m.tampilkanInfo();
        m.tampilkanTunjangan();
        m.tampilkanTotal();
    }
}