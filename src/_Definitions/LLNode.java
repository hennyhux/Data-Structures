package _Definitions;

/*Node to be used in linked list */
public class LLNode {
    /*Private data fields*/
    private int data;
    private LLNode next;
    private LLNode previous;

    /**
     * Default constructor
     */
    public LLNode() {
        this.next = null;
        this.data = 0;
    }

    /**
     * Instantiate a new node with value key
     * @param key the value to instantiate the node with
     */
    public LLNode(int key) {
        this.next = null;
        this.data = key;
    }

    /**
     * Get the next node in the linked list
     * @return the next node in the linked list
     */
    public LLNode getNext() {
        return next;
    }

    /**
     * Set the next node in the linked list to be a certain node
     * @param next the node to be linked up
     */
    public void setNext(LLNode next) {
        this.next = next;
    }

    /**
     * Get the key value of the current node
     * @return value of the current node
     */
    public int getKey() {
        return data;
    }

    /**
     * Set the value of the current node
     * @param key value to set the current node to
     */
    public void setKey(int key) {
        this.data = key;
    }
}
