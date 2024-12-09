/* 1. Преобразовать структуру данных HashSet в структуру TreeSet */

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Task1 {
    public static void main(String[] args) {
        // Создаем HashSet и добавляем элементы
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Orange");
        hashSet.add("Grapes");
        hashSet.add("Peach");
        hashSet.add("Banana");

        // Выводим элементы HashSet
        System.out.println("Элементы HashSet: " + hashSet);

        // Преобразуем HashSet в TreeSet
        TreeSet<String> treeSet = new TreeSet<>(hashSet);

        // Выводим элементы TreeSet
        System.out.println("Элементы TreeSet: " + treeSet);
    }
}
