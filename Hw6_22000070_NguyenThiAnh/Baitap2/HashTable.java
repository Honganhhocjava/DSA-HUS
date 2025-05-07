package Hw6_22000070_NguyenThiAnh.Baitap2;

public class HashTable {
    private int tableSize;

    public HashTable(int size) {
        this.tableSize = size;
    }

    public int hashFunction(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (31 * hash + key.charAt(i)) % tableSize;
        }
        return hash;
    }
}
