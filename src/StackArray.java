/*Author: Henry Zhang*/
/*A stack follows LIFO behavior*/
import java.util.Random;

public class StackArray
{

    /*Size of the array*/
    private int size;

    /*Underlying array that represents the stack*/
    private int[] array;

    /*Top of the stack*/
    private int stackPtr;


    /**
     * Constructor for a new stack
     * @param size size of the stack
     */
    public StackArray(int size)
    {
        this.size = size;
        this.array = new int[size];
        this.stackPtr = -1;
    }

    /**
     * Pushes an element onto the top of the stack
     * @param element element to be added
     */
    public void push(int element)
    {

        if(!isFull())
        {
            stackPtr++;
            array[stackPtr] = element;
        }

        else
        {
            increaseSize();
            push(element);
        }
    }

    /**
     * Pops the top element off the stack
     * @return the element popped
     */
    public int pop()
    {

        if (!isEmpty())
        {
            return array[stackPtr--];
        }

        else {
            System.out.println("The stack is empty");
            return -1;
        }
    }

    /**
     * Increases the size of the array
     */
    public void increaseSize()
    {
        int[] copyArray = new int[size++];

        System.arraycopy(array, 0, copyArray, 0, array.length);

        array = copyArray;
        this.size++;
    }


    /**
     * Check if stack is empty
     * @return true if stack is empty
     */
    public boolean isEmpty()
    {
        return (this.stackPtr == -1);
    }

    /**
     * Checks if stack is full
     * @return true if stack is full
     */
    public boolean isFull()
    {
        return (stackPtr + 1 == size);
    }

    /**
     * Moves the stack pointer down and clears the stack
     */
    public void clearStack()
    {
        this.stackPtr = -1;
    }

    /**
     * Return size of stack
     *
     * @return size of stack
     */
    public int size() {
        return stackPtr + 1;
    }

    /**
     * Main method, driver code
     * @param args command line args
     */
    public static void main (String[] args)
    {

        Random rand = new Random();
        StackArray newStack = new StackArray(rand.nextInt(58));

        System.out.println("Stack size: " + newStack.size);

        assert newStack.isEmpty();
        assert !newStack.isFull();

        for (int i = 0; i < newStack.size; i++) newStack.push(rand.nextInt(999));

        assert !newStack.isEmpty();
        assert newStack.isFull();

        while(!newStack.isEmpty()) System.out.println(newStack.pop());
    }

}





