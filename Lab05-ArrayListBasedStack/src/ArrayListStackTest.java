import java.util.EmptyStackException;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests for the {@link ArrayListStack} class.
 *
 * @author Chris Szafranski
 * @version 2015.10.14
 */
public class ArrayListStackTest
    extends TestCase
{
    // ~ Instance/static variables .............................................

    private ArrayListStack<String> stack;


    // ~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Creates a brand new, empty stack for each test method.
     */
    public void setUp()
    {
        stack = new ArrayListStack<String>();
    }


    // ----------------------------------------------------------
    /**
     * Testing pushing to stack
     */
    public void testPush()
    {
        stack.push("Hello");
        assertEquals("Hello", stack.top());
    }


    // ----------------------------------------------------------
    /**
     * Testing popping from non-empty stack
     */
    public void testPopOnNonEmpty()
    {
        stack.push("Hello");
        stack.push("HI");
        stack.pop(); // deleting top element essentially placing hello on top
        assertEquals("Hello", stack.top());
    }


    // ----------------------------------------------------------
    /**
     * Testing popping from empty stack, exception expected
     */
    public void testPopOnEmpty()
    {
        Exception thrown = null;
        try
        {
            stack.pop();
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
    }


    // ----------------------------------------------------------
    /**
     * Testing toping from non empty stack
     */
    public void testTopOnNonEmpty()
    {
        stack.push("hello");
        assertEquals("hello", stack.top());
    }


    // ----------------------------------------------------------
    /**
     * Testing top method on empty stack, exception expected
     */
    public void testTopOnEmpty()
    {
        Exception thrown = null;
        try
        {
            stack.top();
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
    }


    // ----------------------------------------------------------
    /**
     * Testing getting the size of the stack
     */
    public void testSize()
    {
        stack.push("Hello");
        stack.push("What's up");
        assertEquals(2, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * Testing isEmpty on non-empty stack
     */
    public void testIsEmpty()
    {
        stack.push("hello");
        stack.push("what's up");
        assertEquals(false, stack.isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * Testing non-empty on empty stack
     */
    public void testIsEmptynonEmpty()
    {
        assertEquals(true, stack.isEmpty());
    }

}
