import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests for the {@link Node} class.
 *
 * @author Chris Szafranski 877380293
 * @version 2015.10.19
 */
public class NodeTest
    extends TestCase
{
    // ~ Fields ................................................................

    // these.
    private Node<String> node1;
    private Node<String> node2;
    private Node<String> node3;


    // ~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Create some new nodes for each test method.
     */
    public void setUp()
    {
        node1 = new Node<String>("node1");
        node2 = new Node<String>("node2");
        node3 = new Node<String>("node3");
        // System.out.println(node1.data());

    }


    // ----------------------------------------------------------
    /**
     * This Method will test three cases: Joining one node to another
     */
    public void testJoin()
    {
        node1.join(node2);
        assertEquals(node1.data(), node2.previous().data());
    }


    // ----------------------------------------------------------
    /**
     * This Method will test three cases: Joining one node to another
     */
    public void testJoinOnSelf()
    {
        node1.join(node1);
        assertEquals(node1.data(), node1.previous().data());
    }


    // ----------------------------------------------------------
    /**
     * Tests if node.join(null) leaves node1 unchanged
     */
    public void testJoinNull()
    {

        Exception thrown = null;
        try
        {
            node1.join(null);
            String s = node1.next().data();

        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof NullPointerException);

    }


    // ----------------------------------------------------------
    /**
     * This method will test joining multiple nodes together
     */
    public void testMultiJoin()
    {
        //
        node1.join(node2.join(node3));
        assertEquals(node1.data(), node3.previous().previous().data());
    }


    // ----------------------------------------------------------
    /**
     * This method will test the condition under which a node cannot be added An
     * exception is expected. NullPointerException is not expected
     */
    public void testJoinFailure()
    {
        node1.join(node2);
        Exception thrown = null;
        try
        {
            node1.join(node3);

        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalStateException);
        //
    }


    // ----------------------------------------------------------
    /**
     * Testing severing null.
     */
    public void testSplitnull()
    {
        // code

    }


    // ----------------------------------------------------------
    /**
     * Testing sever method
     */
    public void testSplit()
    {
        // code
        node1.join(node2);
        Node<String> nodetemp = node1.split();
        assertNull(node1.next()); // thes two should be the
        assertNull(node2.previous());
// same

    }
}
