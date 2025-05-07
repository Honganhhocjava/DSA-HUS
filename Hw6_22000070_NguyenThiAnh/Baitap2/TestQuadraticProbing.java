package Hw6_22000070_NguyenThiAnh.Baitap2;

public class TestQuadraticProbing {
    public static void main(String[] args) {
       HashTableWithQuadraticProbing hashTable = new HashTableWithQuadraticProbing();
        hashTable.put("Alice", 25);
        hashTable.put("Bob", 30);
        hashTable.put("Charlie", 35);
        System.out.println("Alice: " + hashTable.get("Alice"));
        System.out.println("Bob: " + hashTable.get("Bob"));
        System.out.println("Charlie: " + hashTable.get("Charlie"));
        System.out.println("Eve: " + hashTable.get("Eve"));
    }
}
