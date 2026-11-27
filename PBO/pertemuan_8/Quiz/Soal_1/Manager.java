package pertemuan_8.Quiz.Soal_1;

// Subclass dari Staff (Multilevel Inheritance)
class Manager extends Staff {
    private double bonus;

    public Manager(String nama, String jabatan, double gaji, double tunjangan, double bonus) {
        super(nama, jabatan, gaji, tunjangan);
        this.bonus = bonus;
    }

    public void tampilkanTotal() {
        double total = gaji + tunjangan + bonus;
        System.out.println("Bonus    : Rp " + (int) bonus);
        System.out.println("Total    : Rp " + (int) total);
    }
}