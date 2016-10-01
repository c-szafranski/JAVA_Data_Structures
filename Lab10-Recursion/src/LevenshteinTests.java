import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test cases for the Levenshtein distance algorithm.
 *
 * @author Chris Szafranski
 * @version 2015.09.24
 */
public class LevenshteinTests
    extends TestCase
{
    private Levenshtein test1; // declaration
    private Levenshtein test2;
    private Levenshtein test3;


    /**
     * General setup
     */
    public void setUp()
    {
        test1 = new Levenshtein("clap", "cram");
        test2 =
            new Levenshtein("this is a long sentence", "this sentence is long");
        test3 = new Levenshtein("mitt", "smitten");
    }


    /**
     * tests distance method.
     */
    public void testDistance()
    {
        assertEquals(2, test1.distance());
        assertEquals(15, test2.distance());
        assertEquals(3, test3.distance());
    }

}
