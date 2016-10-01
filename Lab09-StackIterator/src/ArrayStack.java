import java.util.NoSuchElementException;
import java.util.Iterator;

// -------------------------------------------------------------------------
/**
 * A list-based implementation of a stack.
 *
 * @param <Item>
 *            The type of elements contained in the bag.
 * @author Stephen Edwards
 * @author Chris Szafranski
 * @version 2015.11.05
 */
public class ArrayStack<Item>
    implements Stack<Item>
{
    // ~ Instance/static variables .............................................

    private static final int DEFAULT_CAPACITY = 10;

    private int              size;                 // the current number of
// items in the collection
    private Item[]           contents;             // the set's contents


    // ~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Create an empty stack with the default capacity.
     */
    public ArrayStack()
    {
        size = 0;

        // It is not possible in Java to create a new array containing
        // objects of a generic type like Item, so we have to use a "trick",
        // creating an Object[] array and then telling the compiler to
        // treat it as a Item[] array instead:
        @SuppressWarnings("unchecked")
        Item[] newArray = (Item[])(new Object[DEFAULT_CAPACITY]);

        // Now that we have created the array, we can use it as the
        // initial value for our field
        contents = newArray;
    }


    // ~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Test if the stack is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public int size()
    {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * Make the stack logically empty.
     */
    public void clear()
    {
        size = 0;
    }


    // ----------------------------------------------------------
    /**
     * Insert a new item into the stack.
     *
     * @param value
     *            the item to insert.
     */
    public void push(Item value)
    {
        if (size >= contents.length)
        {
            expandCapacity();
        }

        contents[size] = value;
        ++size;
    }


    // ----------------------------------------------------------
    /**
     * Remove the most recently inserted item from the stack.
     */
    public void pop()
    {
        --size;
    }


    // ----------------------------------------------------------
    /**
     * Get the most recently inserted item in the stack. Does not alter the
     * stack.
     *
     * @return the most recently inserted item in the stack.
     * @precondition The stack is not empty.
     */
    public Item top()
    {
        return contents[size - 1];
    }


    // ----------------------------------------------------------
    /**
     * Return and remove the most recently inserted item from the stack.
     *
     * @return the most recently inserted item in the stack.
     * @precondition The stack is not empty.
     */
    public Item topAndPop()
    {
        pop();
        return contents[size];
    }


    // ----------------------------------------------------------
    /**
     * If necessary will expand size of stack
     */
    private void expandCapacity()
    {
        @SuppressWarnings("unchecked")
        Item[] larger = (Item[])(new Object[contents.length * 2]);

        for (int i = 0; i < size; i++)
        {
            larger[i] = contents[i];
        }

        contents = larger;
    }


    @Override
    public Iterator<Item> iterator()
    {
        StackIterator iterator = new StackIterator();
        return iterator;
    }


    // -------------------------------------------------------------------------
    /**
     * An inner class iterator for a stack The type of elements contained in the
     * bag.
     *
     * @author Chris Szafranski
     * @version 2015.11.05
     */
    private class StackIterator
        implements Iterator<Item>
    {
        private Item[] stackArray;
        private int    toppos = -1; // initial position is at top of stack aka
// not zero


        // ----------------------------------------------------------
        /**
         * StackIterator constructor
         */
        @SuppressWarnings("unchecked")
        public StackIterator()
        {
            stackArray = (Item[])new Object[size];
            for (int i = 0; i < size; i++)
            {
                stackArray[i] = contents[size - 1 - i];
            }

        }


        // ----------------------------------------------------------
        /**
         * Checks for if stack has next
         *
         * @return boolean of type boolean
         */
        public boolean hasNext()
        {
            return toppos < (size - 1);
        }


        // ----------------------------------------------------------
        /**
         * Gets next item in stack
         *
         * @return Item of type Item
         */
        public Item next()
        {
            ++toppos;
            try
            // if it is possible to return the next thing do so
            {
                return stackArray[toppos]; // idk if this is correct
            }
            catch (Exception exception)
            {
                toppos--;
                throw new NoSuchElementException("Stack is empty");
            }

        }


        // ----------------------------------------------------------
        /**
         * Removes top item in stack
         */
        public void remove()
        {
            if ((toppos == -1) || (stackArray[toppos] == null))
            {
                throw new IllegalStateException("Item not in stack");
            }
            stackArray[toppos] = null;

            --size;

        }
    }

}
