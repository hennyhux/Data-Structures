/*Author: Henry Zhang*/
/*In a singularly linked list, each individual node contains data and
a pointer to the next node. Last node points to null*/
import java.util.Random;

/*Defined class for a singular node*/
class Node
{
    public int data;
    public Node next;
}

public class SinglyLinkedList
{

    /*Head of the node*/
    private Node head;

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
     * Insert the node onto the head of the list
     * @param data data to be inserted onto the head
     */
    public void insertHead(int data)
    {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        head = newNode;
    }

    /**
     * Inserts a new node
     * @param data the data to be inserted
     */
    public void insertNode(int data)
    {
        Node newNode = new Node();
        Node copyNode = head;
        newNode.data = data;
        newNode.next = null;

        while (copyNode.next != null)
        {
            copyNode = copyNode.next;
        }

        copyNode.next = newNode;
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
        newList.insertHead(1);

        assert(!newList.checkEmpty());

        for (int i = 0; i < rand.nextInt(200); i++)
        {
            newList.insertNode(rand.nextInt(100));
        }

        newList.printList();
    }

}
