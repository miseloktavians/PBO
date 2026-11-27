package Contoh_Inheritance;

class MenuMinuman {
    String nama;
    void tampilNama() {
        System.out.println("Menu: " + nama);
    }
}

class MinumanDingin extends MenuMinuman {
    void ukuran() {
        System.out.println("Ukuran: Regular");
    }
}

class EsKopi extends MinumanDingin {
    void levelGula() {
        System.out.println("Gula: Less Sugar");
    }
}

public class MainMultilevel {
    public static void main(String[] args) {
        EsKopi k = new EsKopi();
        k.nama = "Kopi Susu Gula Aren";
        
        k.tampilNama(); 
        k.ukuran();     
        k.levelGula(); 
    }
}