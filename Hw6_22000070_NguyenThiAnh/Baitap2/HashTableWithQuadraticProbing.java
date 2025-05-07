package Hw6_22000070_NguyenThiAnh.Baitap2;

public class HashTableWithQuadraticProbing {
    private Entry[] table;
    private final int SIZE = 10;

    public HashTableWithQuadraticProbing() {
        table = new Entry[SIZE];
    }

    private int hash(String key) {
        return key.length() % SIZE;
    }

    public void put(String key, int value) {
        int index = hash(key);
        int i = 1;
        while (table[index] != null && !table[index].key.equals(key)) {
            index = (index + i * i) % SIZE;
            i++;
        }
        table[index] = new Entry(key, value);
    }

    public Integer get(String key) {
        int index = hash(key);
        int i = 1;
        while (table[index] != null && !table[index].key.equals(key)) {
            index = (index + i * i) % SIZE;
            i++;
        }
        return table[index] != null ? table[index].value : null;
    }

    class Entry {
        String key;
        int value;

        public Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

