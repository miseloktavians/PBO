package Pertemuan_2.Soal;

import java.util.Scanner;

public class bangun_ruang_kerucut{
    public static void main(String[] args) {
        Double r,t,s;
        Double volume, luaspermukaan;
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jari-jari :");
        r = input.nextDouble();

        System.out.print("Masukkan tinggi :");
        t = input.nextDouble();

        s = Math.sqrt((r*r) + (t*t));
        volume = (1.0/3.0) * Math.PI * Math.pow(r,2) * t;
        luaspermukaan = Math.PI * r * (r + s);

        System.out.println("hasil garis :"+s);
        System.out.println("hasil volume :"+volume);
        System.out.println("hasil luas :"+Math.round(luaspermukaan));

        input.close();
    }
}