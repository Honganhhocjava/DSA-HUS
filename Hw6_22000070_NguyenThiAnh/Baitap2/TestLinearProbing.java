package Hw6_22000070_NguyenThiAnh.Baitap2;

public class TestLinearProbing {
    public static void main(String[] args) {
        HashTableWithLinearProbing hashTable = new HashTableWithLinearProbing();
        hashTable.put("Alice", 25);
        hashTable.put("Bob", 30);
        hashTable.put("Charlie", 35);
        System.out.println("Alice: " + hashTable.get("Alice")); // Alice: 25
        System.out.println("Bob: " + hashTable.get("Bob"));     // Bob: 30
        System.out.println("Charlie: " + hashTable.get("Charlie")); // Charlie: 35
        System.out.println("Eve: " + hashTable.get("Eve"));     // Eve: null
    }
}