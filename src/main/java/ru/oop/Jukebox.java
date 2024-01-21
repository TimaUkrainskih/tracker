package ru.oop;

public class Jukebox {
    public void music(int position) {
        switch (position) {
            case 1 -> System.out.println("Пусть бегут неуклюже\nПешеходы по лужам\n...");
            case 2 -> System.out.println("Спят усталые игрушки, книжки спят.\nОдеяла и подушки ждут ребят.\n...");
            default -> System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox musicBox = new Jukebox();
        musicBox.music(1);
        musicBox.music(2);
        musicBox.music(3);
    }
}
