package Inheritance;

// (Bertingkat: Menu -> Minuman -> Kopi)

class Menu {
    String nama;
    void tampilNama() {
        System.out.println("Menu: " + nama);
    }
}

class Minuman extends Menu {
    void ukuran() {
        System.out.println("Ukuran: Regular");
    }
}

class Kopi extends Minuman {
    void levelGula() {
        System.out.println("Gula: Less Sugar");
    }
}

public class MainMultilevel {
    public static void main(String[] args) {
        Kopi k = new Kopi();
        k.nama = "Kopi Susu Gula Aren";
        
        k.tampilNama(); 
        k.ukuran();     
        k.levelGula(); 
    }
}