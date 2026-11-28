package Pertemuan_07.Task;

// A typical calling sequence

public class CallingSequence {

    public static void m2() {
        System.out.println("Starting m2");
        System.out.println("Leaving m2");
    }

    public static void m1() {
        System.out.println("Starting m1");
        System.out.println("m1 calling m2");
        m2(); // Push m2 ke Call Stack
        System.out.println("Leaving m1");
    }

    public static void main(String[] args) {
        System.out.println("Starting main");
        System.out.println("main calling m1");
        m1(); // Push m1 ke Call Stack
        System.out.println("Leaving main");
    }
}