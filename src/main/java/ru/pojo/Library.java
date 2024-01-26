package ru.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 67);
        Book book2 = new Book("Winnie-the-Pooh", 250);
        Book book3 = new Book("Jeeves and Wooster stories ", 145);
        Book book4 = new Book("Harry Potter and the Philosopher’s Stone", 600);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getCountPages());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getCountPages());
        }
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getCountPages());
            }
        }
    }
}
