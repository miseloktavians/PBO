package Inheritance;

// (1 Anak punya 2 Induk via Interface)
// Satu class KopiSusu ngambil sifat dari dua interface (BahanKopi dan BahanSusu).

interface BahanKopi {
    void takaranEspresso();
}

interface BahanSusu {
    void jenisSusu();
}

class KopiSusu implements BahanKopi, BahanSusu {
    public void takaranEspresso() {
        System.out.println("Kopi: 2 Shot Espresso");
    }

    public void jenisSusu() {
        System.out.println("Susu: Fresh Milk");
    }
}

public class MainMultiple {
    public static void main(String[] args) {
        KopiSusu ks = new KopiSusu();
        ks.takaranEspresso();
        ks.jenisSusu();
    }
}