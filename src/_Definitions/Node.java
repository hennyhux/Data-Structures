/*Defined class for a node, for use in trees
* Author: Henry Zhang*/
package _Definitions;

public class Node {
    /*Node data*/
    public int key;
    /*Left of node*/
    public Node left;
    /*Right of node*/
    public Node right;
    /*Parent node*/
    public Node parent;

    /**
     * Node constructor
     * @param value
     */
    public Node(int value)
    {
        key = value;
        left = null;
        right = null;
        parent = null;

    }
}