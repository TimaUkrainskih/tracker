package ru.oop;

public class Student {

    public void music() {
        System.out.println("Tra tra tra");
    }

    public void sign() {
        System.out.println("I believe I can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.music();
        petya.music();
        petya.sign();
        petya.sign();
        petya.sign();
    }
}