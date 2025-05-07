package Hw6_22000070_NguyenThiAnh.Baitap2;

class HashTableWithLinearProbing {
    private Entry[] table;
    private final int SIZE = 10;

    public HashTableWithLinearProbing() {
        table = new Entry[SIZE];
    }

    private int hash(String key) {
        return key.length() % SIZE;
    }

    public void put(String key, int value) {
        Entry entry = new Entry(key,value);
        int index = hash(key);

        while (table[index] != null && !table[index].key.equals(key)){
            index = (index+1)% SIZE;
        }
        table[index]= entry;

    }

    public Integer get(String key) {
        int index = hash(key);
        while (table[index] != null && !table[index].key.equals(key)){
            index = (index+1)% SIZE;
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

