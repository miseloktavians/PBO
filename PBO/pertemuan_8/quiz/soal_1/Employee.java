package pertemuan_8.quiz.soal_1;

class Employee {
    protected String nama;
    protected String jabatan;
    protected double gaji;

    public Employee(String nama, String jabatan, double gaji) {
        this.nama = nama;
        this.jabatan = jabatan;
        this.gaji = gaji;
    }

    public void tampilkanInfo() {
        System.out.println("Nama     : " + nama);
        System.out.println("Jabatan  : " + jabatan);
        System.out.println("Gaji     : Rp " + (int) gaji);
    }
}