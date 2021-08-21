package HashTables;
import LinkedList.SinglyLinkedList;
import java.util.Scanner;

public class HashTable {
    /*Current size of the hashtable*/
    private int hashSize;
    /*Underlying representation of a hashtable*/
    private SinglyLinkedList[] buckets;

    /**
     * Default constructor
     *
     * @param hashSize the initial size of the hashtable
     */
    public HashTable(int hashSize) {
        buckets = new SinglyLinkedList[hashSize];
        for (int i = 0; i < hashSize; i++){
            buckets[i] = new SinglyLinkedList();
        }
        this.hashSize = hashSize;
    }

    /**
     * Modular (division) hashing k % m ; where k = key and m = hashSize
     *
     * @param key value to be inserted
     * @return the hash value
     */
    public int hashFunction(int key) {
        return key % hashSize;
    }

    /**
     * Insert key into the hash table
     * ASYMPTOTIC RUNTIME: T(n) is in theta(1)
     *
     * @param key value to be inserted
     */
    public void insert(int key) {
        int hash = hashFunction(key);
        buckets[hash].insert(key);
    }

    /**
     * Delete the key from the hash table
     *
     * @param key item to be deleted
     */
    public void delete(int key) {
        buckets[hashFunction(key)].delete(key);
    }

}
