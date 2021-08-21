/*Author: Henry Zhang*/
/*In a singularly linked list, each individual node contains data and
a pointer to the next node. Last node points to null*/
package LinkedList;
import java.util.Random;
import _Definitions.LLNode;

public class SinglyLinkedList  {

    /*Head of the node*/
    private LLNode head;

    /**
     * Default constructor
     */
    public SinglyLinkedList() {
        this.head = null;
    }   

    /**
     * Checks if a list is empty
     * @return true if empty, false otherwise
     */
    public boolean checkEmpty() {
        return (head == null);
    }

    /**
     * Check for the size of the linked list
     * @return size of the linked list
     */
    public int returnSize() {
        LLNode newNode = head;
        int size = 1;

        if (head == null) return 0;

        while (newNode.getNext() != null)
        {
            size++;
            newNode = newNode.getNext();
        }

        return size;
    }

    /**
     * Inserts the node into the linked list
     * @param data data to be inserted
     */
    public void insert(int data) {
        LLNode newNode = new LLNode();
        newNode.setKey(data);
        newNode.setNext(null);

        if (checkEmpty())
        {
            this.head = newNode;

        } else {
            LLNode iterateNode = head;
            while (iterateNode.getNext() != null)
            {
                iterateNode = iterateNode.getNext();
            }

            iterateNode.setNext(newNode);
        }
    }

    /**
     * Delete an item from the linked list 
     * 
     * @param data the item to be deleted 
     */
    public void delete(int data) {
        if (!checkEmpty()) {
            if (head.getKey() == data) {
                if (head.getNext() != null) head = head.getNext();

                if (head.getNext() == null) head= null;
            }
            else {
                delete(head, data);
            }
        }
        else {
            System.out.println("The list is currently empty");
        }
    }

    /**
     * Private helper function to delete a node if traversal through the linked list is required
     * 
      * @param node head of the linked list 
     * @param data the data to be deleted 
     */    
    private void delete(LLNode node, int data) {
        while (node.getNext() != null) {
            if (node.getNext().getKey() == data) {
                if (node.getNext().getNext() != null) {
                    node.setNext(node.getNext().getNext());
                    node.getNext().setNext(null);
                }
                else {
                    node.setNext(null);
                }
            }
            else {
                node = node.getNext();
            }
        }
    }

    /**
     * Prints out the entire list
     *
     */
    public void printList() {
        System.out.println("Printing List");
        System.out.println("Size of the list: " + returnSize());
        System.out.println("------------------");
        LLNode copyNode = head;
        while (copyNode != null)
        {
            System.out.println(copyNode.getKey());
            copyNode = copyNode.getNext();
        }
    }

    /**
     * Main method, driver code
     *
     * @param args the command line arguments
     */
    public static void main (String[] args) {
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
