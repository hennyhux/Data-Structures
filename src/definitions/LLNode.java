package definitions;

public class LLNode {

    public LLNode head;
    public LLNode next;
    public LLNode previous;
    public int data;

    /**
     * default constructor
     */
    public LLNode(){

        this.next = null;
        this.data = 0;

    }


}
