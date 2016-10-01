import java.util.NoSuchElementException;
import java.util.Iterator;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests for the {@link ArrayStack} class.
 *
 * @author Chris Szafranski
 * @version 2015.11.05
 */
public class ArrayStackTest
    extends TestCase
{
    // ~ Instance/static variables .............................................

    private Stack<String> stack;


    // ~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Create a new test class
     */
    public ArrayStackTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    // ~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Creates a brand new, empty stack for each test method.
     */
    public void setUp()
    {
        stack = new ArrayStack<String>();
    }


    // ----------------------------------------------------------
    /**
     * Tests the size of the stack
     */
    public void testSize()
    {
        String word1 = "word1";
        stack.push(word1);
        String word2 = "word2";
        stack.push(word2);
        String word3 = "word3";
        stack.push(word3);
        String word4 = "word4";
        stack.push(word4);
        assertEquals(4, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * Test the push() method.
     */

    public void testClear()
    {
        //
        stack.push("word");
        stack.push("word");
        stack.push("word");
        stack.clear();
        assertEquals(0, stack.size());

    }


    // ----------------------------------------------------------
    /**
     * Test the push() method.
     */
    public void testPush()
    {
        stack.push("hello");
        assertEquals(1, stack.size());
        assertEquals("hello", stack.top());

        stack.push("goodbye");
        assertEquals(2, stack.size());
        assertEquals("goodbye", stack.top());
    }


    // ----------------------------------------------------------
    /**
     * Test the pop() method.
     */
    public void testPop()
    {
        String word = "hello";
        stack.push(word);
        assertEquals(1, stack.size());

        stack.pop();

        // After removal, make sure the inserted object is no longer there.
        assertEquals(0, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * Test the top() method.
     */
    public void testTop()
    {
        String word = "hello";
        stack.push(word);
        String word1 = "word";
        stack.push(word1);
        assertEquals("word", stack.top());
    }


    // ----------------------------------------------------------
    /**
     * Test the topAndPop() method.
     */
    public void testTopAndPop()
    {
        String word = "hello";
        stack.push(word);

        // Use assertSame() to ensure the specific object added is the
        // one returned here
        assertSame(word, stack.topAndPop());

        // After removal, make sure the inserted object is no longer there.
        assertEquals(0, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * Test clear() with multiple values in the stack.
     */
    public void testRemove3()
    {
        String word1 = "hello";
        stack.push(word1);
        String word2 = "goodbye";
        stack.push(word2);
        assertEquals(2, stack.size());

        stack.clear();
        assertEquals(0, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * Testing the ecpandCapacity() method in the ArrayStack class
     */
    public void testExpandCapacity()
    {
        assertEquals(0, stack.size());
        for (int i = 0; i < 12; i++)
        {
            stack.push("value");
        }
        assertEquals(12, stack.size()); // by this passing the test we know the
    }


    // ----------------------------------------------------------
    /**
     * Tests hasNext() method in StackIterator class
     */
    public void testHasNext()
    {
        //
        String word1 = "word1";
        stack.push(word1);
        String word2 = "word2";
        stack.push(word2);
        String word3 = "word3";
        stack.push(word3);
        String word4 = "word4";
        stack.push(word4);
        Iterator<String> itr = stack.iterator();
        assertEquals(true, itr.hasNext());

    }


    // ----------------------------------------------------------
    /**
     * Will return exception
     */
    public void testHasNextException()
    {
        stack.push("word");
        Iterator<String> itr = stack.iterator();
        itr.next();
        assertFalse(itr.hasNext());
    }


    // ----------------------------------------------------------
    /**
     * check if itereator is created
     */
    public void testIterator()
    {
        assertNotNull(stack.iterator());
    }


    // ----------------------------------------------------------
    /**
     * Tests next() method in StackIterator class
     */
    public void testNext()
    {
        String word1 = "word1";
        stack.push(word1);
        String word2 = "word2";
        stack.push(word2);
        String word3 = "word3";
        stack.push(word3);
        String word4 = "word4";
        stack.push(word4);
        Iterator<String> itr = stack.iterator();
        assertEquals("word4", itr.next());

    }


    // ----------------------------------------------------------
    /**
     * Throws exception
     */
    public void testNextException()
    {
        stack.push("Word");
        Iterator<String> iterator = stack.iterator();
        assertEquals("Word", iterator.next());
        Exception occurred = null;
        try
        {
            iterator.next();
        }
        catch (Exception exception)
        {
            occurred = exception;
        }
        assertNotNull(occurred);
        assertTrue(occurred instanceof NoSuchElementException);
        assertEquals("Stack is empty", occurred.getMessage());

    }


    // ----------------------------------------------------------
    /**
     * Tests remove() method of StackIterator class
     */
    public void testIteratorRemove()
    {
        //
        String word1 = "word1";
        stack.push(word1);

        Iterator<String> itr = stack.iterator();
        Exception occurred = null;
        try
        {
            itr.remove();
        }
        catch (Exception exception)
        {
            occurred = exception;
        }
        assertNotNull(occurred);
        assertTrue(occurred instanceof IllegalStateException);
        assertEquals("Item not in stack", occurred.getMessage());

        occurred = null;
        itr.next();
        itr.remove();

        try
        {
            itr.remove();
        }
        catch (Exception exception)
        {
            occurred = exception;
        }
        assertNotNull(occurred);
        assertTrue(occurred instanceof IllegalStateException);
        assertEquals("Item not in stack", occurred.getMessage());

    }

}
