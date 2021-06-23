/*Author: Henry Zhang*/
/*Some additional notes on hash tables:
* k mod m m is preferably prime to ensure maximum efficiency*/

import java.util.Scanner;

public class HashTables {

    private int hashSize;
    private LinkedList[] buckets;

    /**
     * Default constructor
     *
     * @param hashSize size of the hash table
     */
    public HashTables(int hashSize) {
        buckets = new LinkedList[hashSize];
        for (int i = 0; i < hashSize; i++) {
            buckets[i] = new LinkedList();

        }

        this.hashSize = hashSize;
    }

    /**
     * Hash function...
     *
     * @param key
     * @return
     */
    public int hashFunction(int key) {
        int hash = key % hashSize;
        if (hash < 0) hash += hashSize;
        return hash;
    }


    public int insertHash(int key) {
        int hash = hashFunction(key);
        buckets[hash].insert(key);
        return 0;
    }

    public void deleteHash(int key) {
        int hash = hashFunction(key);
        buckets[hash].delete(key);
    }

    public void displayHashTable() {
        for (int i = 0; i < hashSize; i++) {
            System.out.printf("Bucket %d : ", i);
            System.out.println(buckets[i].display());
        }

    }


    public static class LinkedList {
        private Node first;

        public LinkedList() {
            first = null;
        }

        public void insert(int key) {
            if (isEmpty()) {
                first = new Node(key);
                return;
            }

            Node temp = findEnd(first);
            temp.setNext(new Node(key));
        }

        private Node findEnd(Node n) {
            if (n.getNext() == null) {
                return n;
            } else {
                return findEnd(n.getNext());
            }
        }

        public Node findKey(int key) {
            if (!isEmpty()) {
                return findKey(first, key);
            } else {
                System.out.println("List is empty");
                return null;
            }
        }

        private Node findKey(Node n, int key) {
            if (n.getKey() == key) {
                return n;
            } else if (n.getNext() == null) {
                System.out.println("Key not found");
                return null;
            } else {
                return findKey(n.getNext(), key);
            }
        }

        public void delete(int key) {
            if (!isEmpty()) {
                if (first.getKey() == key) {
                    first = null;
                } else {
                    delete(first, key);
                }
            } else {
                System.out.println("List is empty");
            }
        }

        private void delete(Node n, int key) {
            if (n.getNext().getKey() == key) {
                if (n.getNext().getNext() == null) {
                    n.setNext(null);
                } else {
                    n.setNext(n.getNext().getNext());
                }
            }
        }

        public String display() {
            return display(first);
        }

        private String display(Node n) {
            if (n == null) {
                return "null";
            } else {
                return n.getKey() + "->" + display(n.getNext());
            }
        }

        public boolean isEmpty() {
            return first == null;
        }
    }

    public static class Node {
        private Node next;
        private int key;

        public Node(int key) {
            next = null;
            this.key = key;
        }

        public Node getNext() {
            return next;
        }

        public int getKey() {
            return key;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        }

        public static void main(String args[]) {
            int choice, key;

            HashTables h = new HashTables(7);
            Scanner In = new Scanner(System.in);

            while (true) {
                System.out.println("Enter your Choice :");
                System.out.println("1. Add Key");
                System.out.println("2. Delete Key");
                System.out.println("3. Print Table");
                System.out.println("4. Exit");

                choice = In.nextInt();

                switch (choice) {
                    case 1: {
                        System.out.println("Enter the Key: ");
                        key = In.nextInt();
                        h.insertHash(key);
                        break;
                    }
                    case 2: {
                        System.out.println("Enter the Key delete:  ");
                        key = In.nextInt();
                        h.deleteHash(key);
                        break;
                    }
                    case 3: {
                        System.out.println("Print table");
                        h.displayHashTable();
                        break;
                    }
                    case 4: {
                        In.close();
                        return;
                    }
                }

            }
        }
    }

