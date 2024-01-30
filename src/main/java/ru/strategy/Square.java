package ru.strategy;

public class Square implements Shape {
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return "____________" + ln
                + "|          |" + ln
                + "|          |" + ln
                + "|          |" + ln
                + "____________";
    }
}
