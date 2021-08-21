package BinarySearchTrees;

import _Definitions.Node;

/*In this implementation of a binary search tree, I will be taking a more mathematical approach*/
public class IterativeBST {

    /*The root of the current BST*/
    private Node root;

    /**
     * Default constructor
     */
    public IterativeBST() {
        root = null;
    }

    /**
     * Helper function to determine that appropriate parent for insertion
     * ASYMPTOTIC COMPLEXITY: T(n) is in theta(h)
     * @param z the data being inserted, or the child node
     * @return the parent of the child node
     */
    private Node locateParent(int z) {
        /*y corresponds to parent node of z*/
        Node y = null;
        Node x = this.root;

        /*Loops until an empty position is found*/
        while (x != null)
        {
            y = x;
            if (z < x.key) x = x.left;
            else x = x.right;
        }
        return y;
    }

    /**
     * Insert a new node into the BST
     * ASYMPTOTIC COMPLEXITY: T(n) is in theta(h)
     * @param z the node to be inserted
     */
    public void treeInsert(Node z) {
        Node y = locateParent(z.key);
        z.parent = y;

        if (y == null) this.root = z;

        else if (z.key < y.key) y.left = z;

        else y.right = z;
    }

    /**
     * Inserts the new node and updates the size
     * @param z
     */
    public void insertAndUpdateSize(Node z) {
        treeInsert(z);

    }

    /**
     * Recursively transverse the BST and prints it out in order
     * ASYMPTOTIC COMPLEXITY: T(n) is in theta(n) *guaranteed to visit every node*
     * @param x the root node
     */
    public void inOrderTreeWalk(Node x) {
        if (x != null)
        {
            inOrderTreeWalk(x.left);
            System.out.print(x.key + " ");
            inOrderTreeWalk(x.right);
        }
    }


    /**
     * Check if a specific value is in the BST
     * ASYMPTOTIC COMPLEXITY: T(n) is in theta(h), where h is height of the tree
     * @param x the root or current node
     * @param K the data that is being searched for
     * @return true if the node is found, false otherwise
     */
    public boolean treeSearch(Node x , int K) {
       if (x.key == K) return true;

       else if (K < x.key ) return treeSearch(x.left, K);

       else return treeSearch(x.right, K);

    }

    public static void transplant()
    {

    }

    /**
     * Main function
     * @param args command line args
     */
    public static void main (String[] args)
    {
        IterativeBST tree = new IterativeBST();
        tree.treeInsert(new Node(15));
        tree.treeInsert(new Node(6));
        tree.treeInsert(new Node(18));
        tree.treeInsert(new Node(3));
        tree.treeInsert(new Node(8));
        tree.treeInsert(new Node(17));
        tree.treeInsert(new Node(20));
        tree.treeInsert(new Node(2));
        tree.treeInsert(new Node(4));
        tree.treeInsert(new Node(13));
        tree.treeInsert(new Node(9));

        tree.inOrderTreeWalk(tree.root);
    }
}
