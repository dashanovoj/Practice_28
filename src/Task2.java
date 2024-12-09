/* 2.	Создайте класс Map <String, String> и добавьте десять записей,
которые представляют пары (фамилия, имя).
Проверьте, сколько людей имеют одинаковое имя или фамилию.
Требования к программе:
a)	Программа не должна отображать текст на экране.
b)	Программа не должна считывать значения с клавиатуры
c)	Метод createMap () должен создать и вернуть HashMap,
который имеет элементы (String, String) и содержит 10 записей,
представляющих пары (фамилия, имя).
d)	Метод getSameFirstNameCount () должен возвращать количество людей
с одинаковыми именами.
e)	Метод getSameLastNameCount () должен возвращать количество людей
с одинаковой фамилией */

import java.util.HashMap;
import java.util.Map;

public class Task2 {

    // Реализуем метод для создания и возврата HashMap с 10 записями (фамилия, имя)
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>(); // экземпляр класса HashMap
        map.put("Иванов", "Иван");
        map.put("Петров", "Петр");
        map.put("Сидоров", "Сидор");
        map.put("Кузнецов", "Иван");
        map.put("Смирнов", "Алексей");
        map.put("Попов", "Петр");
        map.put("Васильев", "Алексей");
        map.put("Зайцев", "Сидор");
        map.put("Морозов", "Иван");
        map.put("Новиков", "Павел");
        return map;
    }

    // Реализуем метод для подсчета количества людей с одинаковыми именами
    public static int getSameFirstNameCount(Map<String, String> map) {
        // Введём дополнительный HashMap для отслеживания количества вхождения каждого имени
        HashMap<String, Integer> firstNameCount = new HashMap<>();

        for (String firstName : map.values()) { // проходимся по всем именам в изначальном HashMap
            // Для каждого имени обновляется счетчик в новом HashMap
            // GetOrDefault — это метод, который возвращает значение, соответствующее указанному ключу)
            firstNameCount.put(firstName, firstNameCount.getOrDefault(firstName, 0) + 1);
        }

        int count = 0; // хранение общего количества людей с одинаковыми именами
        for (int value : firstNameCount.values()) {
            if (value > 1) { // если имя повторилось больше одного раза
                count += value; // добавляем это имя к счётчику
            }
        }
        return count;
    }

    // Метод для подсчета количества людей с одинаковыми фамилиями
    public static int getSameLastNameCount(Map<String, String> map) {
        // Введём дополнительный HashMap для отслеживания количества вхождения каждой фамилии
        HashMap<String, Integer> lastNameCount = new HashMap<>();

        // Проходимся по всем ключам в HashMap
        for (String lastName : map.keySet()) {
            lastNameCount.put(lastName, lastNameCount.getOrDefault(lastName, 0) + 1);
        }

        int count = 0;
        for (int value : lastNameCount.values()) {
            if (value > 1) {
                count += value; // Считаем количество людей с одинаковыми фамилиями
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Создаём HashMap
        Map<String, String> map = createMap();
        // Получаем количество людей с одинаковыми именами и фамилиями
        int sameFirstNameCount = getSameFirstNameCount(map);
        int sameLastNameCount = getSameLastNameCount(map);

        /* Повторных фамилий нет, так как HashMap
        не допускает повторность ключей - они перезаписываются, однако
        при разных ключах возможно одинаковые значения (повторяющиеся имена) */
        System.out.println("Количество людей с одинаковыми именами: " + sameFirstNameCount);
        System.out.println("Количество людей с одинаковыми фамилиями: " + sameLastNameCount);
    }
}

