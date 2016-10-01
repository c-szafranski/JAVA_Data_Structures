import java.util.ArrayList;
import java.util.EmptyStackException;

// -------------------------------------------------------------------------
/**
 * An implementation of the stack data type that adapts an ArrayList to store
 * its contents.
 *
 * @param <T>
 *            the type of elements stored in the stack
 * @author Tony Allevato (authored class skeleton)
 * @author Chris Szafranski
 * @version 2015.10.14
 */
public class ArrayListStack<T>
    implements SimpleStack<T>
{
    // ~ Instance/static variables ............................................

    private ArrayList<T> stack;


    // ~ Constructors .........................................................

    // ----------------------------------------------------------
    // ----------------------------------------------------------
    /**
     * Create a new ArrayListStack object.
     */
    public ArrayListStack()
    {
        stack = new ArrayList<T>(); // initializing empty stack
    }


    // ~ Methods ..............................................................

    // ----------------------------------------------------------
    /**
     * pushes a item of type <T> to the stack
     *
     * @param item
     *            of type <T>
     */
    public void push(T item)
    {
        stack.add(item); // version of add that adds item to end of list

    }


    // ----------------------------------------------------------
    /**
     * Deletes the last item in a stack
     */
    public void pop()
    {
        try
        {
            stack.remove(stack.size() - 1); // remove the last item on stack
        }
        catch (Exception exception)
        {

            throw new EmptyStackException();
        }

    }


    // ----------------------------------------------------------
    /**
     * pops the item off the top of the stack. item still exists on stack call
     * pop() to delete
     *
     * @return item of type <T>
     */
    public T top()
    {
        try
        {
            return stack.get(stack.size() - 1); // returns the last element in
// stack
        }
        catch (Exception exception)
        {

            throw new EmptyStackException();
        }

    }


    // ----------------------------------------------------------
    /**
     * Checks if stack is empty
     *
     * @return size of stack
     */
    public int size()
    {
        return stack.size();

    }


    // ----------------------------------------------------------
    /**
     * Checks if stack is empty
     *
     * @return if stack is empty
     */
    public boolean isEmpty()
    {
        return stack.isEmpty();

    }
}
