package pertemuan_8.Quiz.Soal_2;

public class MainFruits {
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