import java.util.EmptyStackException;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests for the {@link LinkedStack} class.
 *
 * @author Chris Szafranski 877380293
 * @version 2015.10.19
 */
public class LinkedStackTest
    extends TestCase
{
    // ~ Fields ................................................................

    private LinkedStack<String> stack;


    // ~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Creates a brand new, empty stack for each test method.
     */
    public void setUp()
    {
        stack = new LinkedStack<String>();
    }


    // ----------------------------------------------------------
    /**
     * tests single push
     */
    public void testPush()
    {
        stack.push("hello");
        assertEquals("hello", stack.peek());
    }


    // ----------------------------------------------------------
    /**
     * Testing that multi push works
     */
    public void testMultiPush()
    {

        stack.push("hello");
        stack.push("nope");
        stack.push("good");
        assertEquals("good", stack.peek());
    }


    // ----------------------------------------------------------
    /**
     * Testing to see if pop works on non-empty stack
     */
    public void testPop()
    {
        stack.push("hello");
        stack.push("good");
        stack.pop();
        assertEquals("hello", stack.peek());
    }


    // ----------------------------------------------------------
    /**
     * Testing for pops on empty stack
     */
    public void testPopOnEmpty()
    {
        Exception thrown = null;
        try
        {
            stack.push("hello");
            stack.push("nope");
            stack.push("good");
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();

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
     * testing peek method
     */
    public void testPeek()
    {
        stack.push("hello");
        assertEquals("hello", stack.peek());
    }


    // ----------------------------------------------------------
    /**
     * testing peek on empty stack
     */
    public void testPeekEmpty()
    {
        Exception thrown = null;
        try
        {
            stack.peek();

        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
    }

}
