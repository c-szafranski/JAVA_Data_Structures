import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests for the {@link ListBasedBag} class.
 *
 * @author Chris Szafranski
 * @version (2015.10.08)
 */
public class ListBasedBagTest
    extends TestCase
{
    // ~ Instance/static variables .............................................

    private ListBasedBag<Book>   bag1;
    private Book                 book1;
    private Book                 book2;
    private ListBasedBag<String> bag2;


    // ~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Create a new test class
     */
    public ListBasedBagTest()
    {
        // empty constructor
    }


    // ----------------------------------------------------------
    /**
     * Creates a brand new, empty bag and a new 6-sided die as the test fixture
     * for each test method.
     */
    public void setUp()
    {
        bag1 = new ListBasedBag<Book>();
        book1 =
            new Book(
                "Data Structures: Abstraction and Design Using Java",
                "Elliot B. Koffman and Paul A. T. Wolfgang",
                "978-0-470-12870-1");
        book2 =
            new Book(
                "Data Structures and Problem Solving Using Java",
                "James Charles",
                "0435643234");
        bag2 = new ListBasedBag<String>();
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#ListBasedBag()}. public void
     * testArrayBag() { // Check that a new bag is empty // Initially, its size
     * should be zero assertEquals(0, bag1.size()); // It shouldn't contain our
     * test die assertFalse(bag1.contains(book1)); // If we try to pull out an
     * element, nothing should come out assertNull(bag1.removeRandom()); } //
     * ---------------------------------------------------------- /** Test
     * method for {@link ListBasedBag#add(java.lang.Object)}. public void
     * testAdd() { bag1.add(book1); assertEquals(true, bag1.contains(book1)); }
     * // ---------------------------------------------------------- /** Test
     * method for {@link ListBasedBag#remove(java.lang.Object)}.
     */
    public void testRemove()
    {
        bag1.add(book1);
        assertEquals(null, bag1.remove(book2));
        assertEquals(book1, bag1.remove(book1));
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#removeRandom()}
     */
    public void testRemoveRandom()
    {
        bag1.add(book1);
        assertEquals(book1, bag1.removeRandom());
    }


    // ----------------------------------------------------------
    /**
     * Tests contains method
     */
    public void testContains()
    {
        bag1.add(book1);
        assertEquals(true, bag1.contains(book1)); // true
        assertEquals(false, bag1.contains(book2));
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#isEmpty()}.
     */
    public void testIsEmpty()
    {
        bag1.add(book1);
        assertEquals(false, bag1.isEmpty());
        assertEquals(true, bag2.isEmpty()); // true
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#size()}.
     */
    public void testSize()
    {
        assertEquals(0, bag1.size()); // 0
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#toString()}.
     */
    public void testToString()
    {
        bag1.add(book1);
        bag1.add(book2);
        assertEquals(
            "{" + book1.toString() + "," + book2.toString() + "}",
            bag1.toString());
        assertEquals("{}", bag2.toString());
    }

}
