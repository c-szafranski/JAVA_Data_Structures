package cs2114;

// -------------------------------------------------------------------------
/**
 * This class will do stuff
 *
 * @param <E>
 * @author Chris Szafranski
 * @version Oct 29, 2015
 */
public class Lab08Deque<E>
    extends DoubleLinkDeque<E>
{
    // ----------------------------------------------------------
    /**
     * Create a new default Lab08Deque object.
     */
    public Lab08Deque()
    {
        super();

    }


    /*
     *
     *
     */
    @Override
    public void enqueueAtFront(E value)
    {
        //
        Node<E> newNode = new Node<E>(value);
        newNode.setNext(head);
        head.getPrevious().setNext(newNode);
        head.setPrevious(newNode);
        this.size++;

    }


    /*
     *
     *
     */
    @Override
    public E dequeueAtFront()
    {
        // TODO Auto-generated method stub
        return null;
    }


    /*
     *
     *
     */
    @Override
    public void enqueueAtRear(E value)
    {
        // TODO Auto-generated method stub

    }


    /*
     *
     *
     */
    @Override
    public E dequeueAtRear()
    {
        // TODO Auto-generated method stub
        return null;
    }


    /*
     *
     *
     */
    @Override
    public E frontItem()
    {
        // TODO Auto-generated method stub
        return null;
    }


    /*
     *
     *
     */
    @Override
    public E rearItem()
    {
        // TODO Auto-generated method stub
        return null;
    }


    /*
     *
     *
     */
    @Override
    public void clear()
    {
        // TODO Auto-generated method stub

    }

}
