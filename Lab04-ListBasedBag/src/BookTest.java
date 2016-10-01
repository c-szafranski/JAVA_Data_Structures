import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests for the {@link Book} class.
 *
 * @author Stephen Edwards (authored class skeleton)
 * @author Zev Koffsky (823338740)
 * @version (2015.10.08)
 */
public class BookTest
    extends TestCase
{
    // ~ Instance/static variables .............................................

    private Book book;
    private Book book2;
    private Book book2a;


    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Create a new test class
     */
    public BookTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    // ~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Creates a brand new book as the test fixture for each test method.
     */
    public void setUp()
    {
        book =
            new Book(
                "Data Structures: Abstraction and Design Using Java",
                "Elliot B. Koffman and Paul A. T. Wolfgang",
                "978-0-470-12870-1");

        book2 =
            new Book(
                "Data Structures and Problem Solving Using Java",
                "James Anthony Charles",
                "0435643234");

        book2a =
            new Book(
                "Data Structures and Problem Solving Using Java",
                "James Charles",
                "0435643234");
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link Book#Book(String, String, String)}.
     */
    public void testBook()
    {
        assertEquals(
            "Data Structures: Abstraction and Design Using Java",
            book.getTitle());
        assertEquals(
            "Elliot B. Koffman and Paul A. T. Wolfgang",
            book.getAuthor());
        assertEquals("978-0-470-12870-1", book.getIsbn());
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link Book#setTitle(String)}.
     */
    public void testSetTitle()
    {
        book.setTitle("A Different Title");
        assertEquals("A Different Title", book.getTitle());
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link Book#setAuthor(String)}.
     */
    public void testSetAuthor()
    {
        book.setAuthor("Joe Hokie");
        assertEquals("Joe Hokie", book.getAuthor());
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link Book#setIsbn(String)}.
     */
    public void testSetIsbn()
    {
        book.setIsbn("1234567890");
        assertEquals("1234567890", book.getIsbn());
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link Book#toString()}.
     */
    public void testToString()
    {
        assertEquals("Data Structures: Abstraction and Design Using Java, "
            + "Elliot B. Koffman and Paul A. T. Wolfgang, "
            + "978-0-470-12870-1", book.toString());
    }


    // ----------------------------------------------------------
    /**
     * test if two books are equal.
     */
    public void testEquals()
    {
        assertEquals(true, book.equals(book));
        assertEquals(true, book2.equals(book2a));
        assertEquals(false, book2.equals(5));
        assertEquals(false, book2.equals(book));
    }

}
