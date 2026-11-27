package pertemuan_8.quiz.soal_3;

class Teacher extends Person {
    String mataKuliah = "Pemrograman Berorientasi Objek";

    public void mengajar() {
        System.out.println("Peran        : Dosen Pengampu (" + mataKuliah + ")");
    }
}