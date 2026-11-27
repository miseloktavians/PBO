package Pertemuan_8.Quiz.Soal_1;

// Subclass dari Employee
class Staff extends Employee {
    protected double tunjangan;

    public Staff(String nama, String jabatan, double gaji, double tunjangan) {
        super(nama, jabatan, gaji);
        this.tunjangan = tunjangan;
    }

    public void tampilkanTunjangan() {
        System.out.println("Tunjangan: Rp " + (int) tunjangan);
    }
}

