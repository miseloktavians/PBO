package Pertemuan_07.Task;

// Call Frames – Reference Variables

public class ReferenceDemo {

    public static void printAll(String s1, String s2) {
        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }

    public static void main(String[] args) {
        // Reference variables disimpan di Stack, Objek String disimpan di Heap
        String str1 = new String("Misel");
        String str2 = new String("Informatika");

        printAll(str1, str2);
    }
}