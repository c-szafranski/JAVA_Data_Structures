// -------------------------------------------------------------------------
/**
 * A "node" represents a single element in a sequence. Think of it like a link
 * in a chain -- the node contains an element of data and reference to the
 * previous and next elements in the sequence. This node is "doubly linked" --
 * it has references to the next node in the chain and the previous node in the
 * chain. You must implement the join and split methods to manage both
 * connections simultaneously, ensuring that the consistency of links in the
 * chain is preserved at all times.
 *
 * @param <E>
 *            the element type stored in the node
 * @author Chris Szafranski 877380293
 * @version 2015.10.19
 */
public class Node<E>
{
    // ~ Fields ................................................................

    // The data element stored in the node.
    private E       data;
    // these are two mem locations that will act as pointers to previous node
    // and next node
    // The next node in the sequence.
    private Node<E> next;

    // The previous node in the sequence.
    private Node<E> previous;


    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Node with the specified data.
     *
     * @param data
     *            the data for the node
     */
    public Node(E data)
    {
        this.data = data;

    }


    // ~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Gets the data in the node.
     *
     * @return the data in the node
     */
    public E data()
    {
        return this.data;
    }


    // ----------------------------------------------------------
    /**
     * Sets the data in the node.
     *
     * @param newData
     *            the new data to put in the node
     */
    public void setData(E newData)
    {
        this.data = newData;
    }


    // ----------------------------------------------------------
    /**
     * Gets the node that follows this one in the sequence.
     *
     * @return the node that follows this one in the sequence
     */
    public Node<E> next()
    {
        return next;
    }


    // ----------------------------------------------------------
    /**
     * Gets the node that precedes this one in the sequence.
     *
     * @return the node that precedes this one in the sequence
     */
    public Node<E> previous()
    {
        return previous;
    }


    // ----------------------------------------------------------
    /**
     * <p>
     * Joins this node to the specified node so that the one passed as a
     * parameter follows this node. In other words, writing {@code A.join(B)}
     * would create the linkage A <-> B.
     * </p>
     * <p>
     * This method should throw an IllegalStateException if this node already
     * has another node following it, or if {@code newNext} already has another
     * node preceding it. In this case, it's up to the user to call
     * {@link #split()} to sever the connection between the nodes before they
     * can join them to something else.
     * </p>
     * <p>
     * It is acceptable for {@code newNext} to be null if this node's next
     * reference is already null. This situation should not throw an exception.
     * </p>
     * <p>
     * After connecting the nodes, the method should return {@code this}, which
     * allows users to nest multiple calls to join to create longer chains, like
     * {@code A.join(B.join(C))}.
     * </p>
     *
     * @param newNext
     *            the node that should follow this one
     * @return this node
     * @throws IllegalStateException
     *             if there is already a node following this node or if there is
     *             already a node preceding {@code newNext}
     */
    public Node<E> join(Node<E> newNext)
    {
        if (newNext == null)
        {
            return this; // this might have to be changed to null
        }
        // in the case user types A.join(A); loop the node in on itself
        else if (newNext == this)
        {

            this.next = this;
            this.previous = this;
            return this;
        }
        // first we state the condition under which the method would work
        else if (this.next() == null && newNext.previous() == null)
        {
            //
            this.next = newNext;
            newNext.previous = this; // check availability on this information
            this.previous = null;
            return this;
        }

        else
        {
            throw new IllegalStateException(
                "Node operated on must have null next() pointer");
        }
    }


    // ----------------------------------------------------------
    /**
     * <p>
     * Splits this node from its follower and then returns the follower.
     * </p>
     * <p>
     * It is acceptable for this method to be called on a node that has a null
     * follower. In that case, the method simply does nothing and returns null.
     * </p>
     * <p>
     * There are no circumstances under which this method should throw an
     * exception.
     * </p>
     *
     * @return the node that followed this node before they were split
     */
    public Node<E> split()
    {
        if (this.next() == null)
        {
            return null;
        }
        else
        {
            Node<E> temp = this.next();
            this.next = null; // sever connection of next to previous
            temp.setPrevious(null); // then sever connection from this to next
            return temp;
        }

    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * @param node
     */
    public void setPrevious(Node<E> node)
    {
        this.previous = node;
    }
}
