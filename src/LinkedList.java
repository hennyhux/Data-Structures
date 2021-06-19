/*In a singularly linked list, each individual node contains data and
a pointer to the next node. Last node points to null*/
import java.util.Random;

/*Defined class for a singular node*/
class Node
{
    public int data;
    public Node next;
}

public class LinkedList
{
    //head of the list
    private Node head;

    //Checks if the list is empty
    public boolean checkEmpty()
    {
        return (head == null);
    }

    //Checks for the size of the linked list
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

    //insert head node
    public void insertHead(int data)
    {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        head = newNode;
    }

    //insert a new node
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

    //prints out the entire linked list
    public void printList()
    {
        System.out.println("Printing List");
        System.out.println("------------------");
        Node copyNode = head;
        while (copyNode != null)
        {
            System.out.println(copyNode.data);
            copyNode = copyNode.next;
        }

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main (String[] args)
    {
        LinkedList newList = new LinkedList();
        Random rand = new Random();
        newList.insertHead(1);

        for (int i = 0; i < 30; i++)
        {
            newList.insertNode(rand.nextInt(100));
        }

        newList.printList();
    }

}
