package pertemuan_8.quiz.soal_2;

public class QuizFruits {
    public static void main(String[] args) {
        Apple apel = new Apple();
        apel.infoBuah();
        apel.rasaApel();

        System.out.println();

        Mango mangga = new Mango();
        mangga.infoBuah();
        mangga.rasaMangga();

        System.out.println();

        Orange jeruk = new Orange();
        jeruk.infoBuah();
        jeruk.rasaJeruk();
    }
}