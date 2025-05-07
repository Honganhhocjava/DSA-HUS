package Hw6_22000070_NguyenThiAnh.Baitap2;

// Hàm băm thứ hai thường được chọn để tránh lặp lại chỉ số băm, ví dụ: h2(k) = 7 − (k%7)
class HashTableWithDoubleHashing {
    private Entry[] table;
    private final int SIZE = 10;

    public HashTableWithDoubleHashing() {
        table = new Entry[SIZE];
    }

    private int hash1(String key) {
        return key.length() % SIZE;
    }

    private int hash2(String key) {
        return 7 - (key.length() % 7);
    }

    public void put(String key, int value) {
        int index = hash1(key);
        int step = hash2(key);
        while (table[index] != null && !table[index].key.equals(key)) {
            index = (index + step) % SIZE;
        }
        table[index] = new Entry(key, value);
    }

    public Integer get(String key) {
        int index = hash1(key);
        int step = hash2(key);
        while (table[index] != null && !table[index].key.equals(key)) {
            index = (index + step) % SIZE;
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

