/* 3. Реализовать хеш-таблицу, в которой ключи имеют
вещественные значения */
import java.util.LinkedList;

class Task3 {
    public static class HashTable {
        private static final int INITIAL_CAPACITY = 16; // начальный размер таблицы
        private LinkedList<Entry>[] table; // массив связанных списков для хранения элементов
        private int size; // количество элементов в таблице

        // Внутренний класс для хранения пар ключ-значение
        private static class Entry {
            // Поля данных
            double key;
            String value;

            // Конструктор
            Entry(double key, String value) {
                this.key = key;
                this.value = value;
            }
        }

        // Конструктор
        public HashTable() {
            table = new LinkedList[INITIAL_CAPACITY];
            for (int i = 0; i < INITIAL_CAPACITY; i++) {
                table[i] = new LinkedList<>();
            }
            size = 0;
        }

        // Хеш-функция для вещественных чисел
        private int hash(double key) {
            // Принимаем значение типа double в качестве аргумента
            int hashCode = Double.hashCode(key);
            return Math.abs(hashCode) % table.length; // возвращает индекс в пределах массива
        }

        // Метод для добавления элемента в таблицу
        public void put(double key, String value) {
            int index = hash(key);
            for (Entry entry : table[index]) {
                if (entry.key == key) {
                    entry.value = value; // обновляем значение, если ключ уже существует
                    return;
                }
            }
            // Если ключ не найден
            table[index].add(new Entry(key, value)); // добавляем новую пару ключ-значение
            size++;
        }

        // Метод для получения значения по ключу
        public String get(double key) {
            int index = hash(key);
            for (Entry entry : table[index]) {
                if (entry.key == key) {
                    return entry.value; // возвращаем значение, если ключ найден
                }
            }
            // Если ключ не найден
            return null; // возвращаем null
        }

        // Метод для удаления элемента по ключу
        public void remove(double key) {
            int index = hash(key);
            Entry toRemove = null;
            for (Entry entry : table[index]) {
                if (entry.key == key) {
                    toRemove = entry; // находим элемент для удаления
                    break;
                }
            }
            if (toRemove != null) {
                table[index].remove(toRemove); // удаляем элемент
                size--;
            }
        }

        // Метод для получения размера хеш-таблицы
        public int size() {
            return size;
        }

        public static void main(String[] args) {
            HashTable hashTable = new HashTable();
            hashTable.put(3.14, "Число Пи");
            hashTable.put(2.71, "Число Эйлера");
            hashTable.put(1.618, "Золотое сечение");

            System.out.println("Значение для ключа 3.14: " + hashTable.get(3.14));
            System.out.println("Значение для ключа 2.71: " + hashTable.get(2.71));

            hashTable.remove(2.71);
            System.out.println("Значение для ключа 2.71 после удаления: " + hashTable.get(2.71));
        }
    }
}

