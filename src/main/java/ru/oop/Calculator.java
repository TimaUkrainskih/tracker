package ru.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return x - y;
    }

    public double divide(int y) {
        return (double) y / x;
    }

    public int multiply(int y) {
        return y * x;
    }

    public double sumAllOperation(int y) {
        return sum(y) + minus(y) + divide(y) + multiply(y);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        result = Calculator.minus(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        System.out.println(calculator.divide(10));
        System.out.println(calculator.sumAllOperation(10));
    }
}
