/*Author: Henry Zhang*/
/*In a singularly linked list, each individual node contains data and
a pointer to the next node. Last node points to null*/
import java.util.Random;


public class SinglyLinkedList
{
    /*Defined class for a singular node*/
    public static class Node
    {
        private int data;
        private Node next;

        public Node()
        {
            this.next = null;
            this.data = 0;
        }

        public Node(int key)
        {
            this.next = null;
            this.data = key;
        }

        public Node getNext()
        {
            return next;
        }

        public void setNext()
        {
            this.next = next;
        }

        public int getKey()
        {
            return data;
        }

    }


    /*Head of the node*/
    private Node head;


    /**
     * Default constructor
     */
    public SinglyLinkedList()
    {
        this.head = null;
    }   

    /**
     * Checks if a list is empty
     * @return true if empty
     */
    public boolean checkEmpty()
    {
        return (head == null);
    }

    /**
     * Check for the size of the linked list
     * @return size of the linked list
     */
    public int returnSize()
    {
        Node newNode = head;
        int size = 0;

        while (newNode.next != null)
        {
            size++;
            newNode = newNode.next;
        }

        return size;
    }

    /**
     * Inserts the node into the linked list
     * @param data data to be inserted
     */
    public void insert(int data)
    {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (checkEmpty())
        {
            this.head = newNode;

        } else {
            Node iterateNode = head;
            while (iterateNode.next != null)
            {
                iterateNode = iterateNode.next;
            }

            iterateNode.next = newNode;
        }
    }

    public void hashInsert(int key)
    {
        if (checkEmpty())
        {
            this.head = new Node();
        }
    }


    /**
     * Prints out the entire lsit
     */
    public void printList()
    {
        System.out.println("Printing List");
        System.out.println("Size of the list: " + returnSize());
        System.out.println("------------------");
        Node copyNode = head;
        while (copyNode != null)
        {
            System.out.println(copyNode.data);
            copyNode = copyNode.next;
        }

    }

    /**
     * Main method, driver code
     *
     * @param args
     *            the command line arguments
     */
    public static void main (String[] args)
    {
        SinglyLinkedList newList = new SinglyLinkedList();
        Random rand = new Random();

        assert(!newList.checkEmpty());

        for (int i = 0; i < rand.nextInt(200); i++)
        {
            newList.insert(rand.nextInt(100));
        }

        newList.printList();
    }

}
