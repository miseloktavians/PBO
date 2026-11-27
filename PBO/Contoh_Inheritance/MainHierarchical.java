package Contoh_Inheritance;

// (Bercabang: 1 Induk -> 2 Anak)
// Satu induk MenuCafe diwariskan ke dua anak (Kopi dan NonKopi).

class MenuCafe {
    String namaCafe = "Kopi Senja";
    void infoCafe() {
        System.out.println("Cafe: " + namaCafe);
    }
}

class Kopi extends MenuCafe {
    void hargaKopi() {
        System.out.println("Americano - 20k");
    }
}

class NonKopi extends MenuCafe {
    void hargaNonKopi() {
        System.out.println("Matcha Latte - 25k");
    }
}

public class MainHierarchical {
    public static void main(String[] args) {
        Kopi k = new Kopi();
        k.infoCafe();
        k.hargaKopi();

        System.out.println("---------------------");

        NonKopi nk = new NonKopi();
        nk.infoCafe();
        nk.hargaNonKopi();
    }
}