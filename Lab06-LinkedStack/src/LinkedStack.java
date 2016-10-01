import java.util.EmptyStackException;

// -------------------------------------------------------------------------
/**
 * An implementation of the stack data type that uses a linked chain of
 * {@code Node<E>} objects to store its contents. This is a PARTIAL
 * IMPLEMENTATION that needs completion.
 *
 * @param <E>
 *            the type of elements stored in the stack
 * @author Chris Szafranski 877380293
 * @version 2015.10.19
 */
public class LinkedStack<E>
    implements StackInterface<E>
{
    // ----------------------------------------------------------
    /**
     * Create a new LinkedStack object.
     */
    // ~ Fields ...............................................................
    private int     stacksize;
    private Node<E> curr;


    // ----------------------------------------------------------
    /**
     * Create a new LinkedStack object.
     */
    //

    // ~ Constructors .........................................................

    // ----------------------------------------------------------
    /*
     * Create a new LinkedStack object.
     */
    public LinkedStack()
    {
        Node<E> root = new Node<E>(null);
        curr = root;
        this.stacksize = 0; // Nothing in this method, empty stack of no nodes
    }


    // ~ Methods ..............................................................

    // ----------------------------------------------------------
    /*
     * push adds a node of type E to the stack
     */
    public void push(E item)
    {
        Node<E> temp = new Node<E>(item);
        curr.join(temp);
        curr = temp;
        this.stacksize++;

    }


    // ----------------------------------------------------------
    /*
     * The pop method //
     * ----------------------------------------------------------
     */
    public void pop()
    {
        if (this.isEmpty())
        {
            throw new EmptyStackException();

        }
        else
        {
            curr.split();
            curr = curr.previous();
            this.stacksize--;

        }

    }


    // ----------------------------------------------------------
    /*
     * Peek returns the top element in the stack
     * @return a node
     */
    public E peek()
    {
        if (this.isEmpty())
        {
            throw new EmptyStackException();
        }
        return curr.data();

    }


    // ----------------------------------------------------------
    /*
     * checks if stack is empty
     * @return boolean value of if the stack is empty
     */
    public boolean isEmpty()
    {
        if (this.stacksize == 0)
        {
            return true; // stack is empty
        }
        return false;

    }
}
