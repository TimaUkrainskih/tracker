package ru.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("No such element");
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"Cat", "Dog", "Animal"};
        try {
            indexOf(words, "Bird");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }


    }
}