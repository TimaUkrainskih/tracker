package ru.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Никитан Тимофей");
        student.setGroup("ИУ8-54");
        student.setReceiptDate(LocalDate.of(2021, 9, 1));
        String ln = System.lineSeparator();
        System.out.println(student.getFullName() + ln
                + student.getGroup() + ln
                + student.getReceiptDate());
    }
}
