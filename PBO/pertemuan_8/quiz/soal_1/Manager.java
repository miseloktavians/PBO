package pertemuan_8.quiz.soal_1;

class Manager extends Staff {
    protected double bonus;

    public Manager(String nama, String jabatan, double gaji, double tunjangan, double bonus) {
        super(nama, jabatan, gaji, tunjangan);
        this.bonus = bonus;
    }

    public void tampilkanTotal() {
        double total = gaji + tunjangan + bonus;
        System.out.println("Bonus   : Rp " + (int) bonus);
        System.out.println("Total   : Rp " + (int) total);
    }
}
