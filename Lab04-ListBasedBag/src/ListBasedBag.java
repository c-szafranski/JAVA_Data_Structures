import java.util.Random;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * This class represents an implementation of a bag collection that internally
 * uses an ArrayList to hold the items.
 *
 * @param <T>
 *            The type of items this bag will hold.
 * @author John Lewis, Tony Allevato (authored class skeleton)
 * @author Chris Szafranski
 * @version 2015.10.08
 */
public class ListBasedBag<T>
    implements Bag<T>
{
// ~ Instance/static variables .............................................

// The default initial capacity of the bag
    private static final int DEFAULT_CAPACITY = 100;

// A single random number generator shared by all bags
    private static Random    rand             = sofia.util.Random.generator();

    private ArrayList<T>     alist;


// ----------------------------------------------------------
    /**
     * Creates an empty bag using the default capacity.
     */
    public ListBasedBag()
    {
        this(DEFAULT_CAPACITY);
    }


// ----------------------------------------------------------
    /**
     * Creates an empty bag using the specified capacity.
     *
     * @param initialCapacity
     *            initial capacity of the arraylist
     */
    public ListBasedBag(int initialCapacity)
    {
        alist = new ArrayList<T>(initialCapacity);
    }


// ~ Public methods ........................................................

// ----------------------------------------------------------
    /**
     * Adds the specified element to the bag.
     *
     * @param element
     *            item to be added
     * @precondition parameter element is not null
     */
    public void add(T element)
    {
        alist.add(element);
    }


// ----------------------------------------------------------
    /**
     * Removes and returns the specified element from the bag. If multiple
     * copies of the same element appear in the bag, only one is removed.
     *
     * @param target
     *            item to be removed
     * @return the item removed or null if not found
     * @precondition parameter target is not null
     * @postcondition returned value x.equals(target)
     */
    public T remove(T target)
    {
        for (int i = 0; i < alist.size(); i++)
        {
            if (alist.get(i).equals(target))
            {
                return alist.remove(i);
            }

        }
        return null;
    }


// ----------------------------------------------------------
    /**
     * Removes and returns a random element from the bag.
     *
     * @return the element removed or null if the bag is empty
     */
    public T removeRandom()
    {
        if (alist.size() <= 0)
        {
            return null;
        }
        return alist.remove(rand.nextInt() % alist.size());
    }


// ----------------------------------------------------------
    /**
     * Determines if the bag contains the specified element.
     *
     * @param key
     *            element to be found
     * @return true if target is in the collection, false otherwise
     * @precondition parameter target is not null
     */
    public boolean contains(T key)
    {

        for (int i = 0; i < alist.size(); i++)
        {
            if (alist.get(i).equals(key))
            {
                return true;
            }
        }
        return false;
    }


// ----------------------------------------------------------
    /**
     * Determines if the bag contains no elements.
     *
     * @return true if collection is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return alist.isEmpty();
    }


// ----------------------------------------------------------
    /**
     * Determines the number of elements currently in the bag.
     *
     * @return the number of elements in the bag
     */
    public int size()
    {
        return alist.size();
    }


// ----------------------------------------------------------
    /**
     * Returns a string representation of this bag. A bag's string
     * representation is written as a comma-separated list of its contents (in
     * some arbitrary order) surrounded by curly braces, like this:
     *
     * <pre>
     * { 52, 14, 12, 119, 73, 80, 35 }
     * </pre>
     * <p>
     * An empty bag is simply {}.
     * </p>
     *
     * @return a string representation of the bag and its contents
     */
    public String toString()
    {
        if (alist.size() == 0)
        {
            return "{}";
        }
        String a = "{" + alist.get(0);
        for (int i = 1; i < alist.size(); i++)
        {
            a = a + ",";
            a = a + alist.get(i);
        }
        a = a + "}";
        return a;
    }
}
