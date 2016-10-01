package cs2114;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * This is a test class for the methods implemented in the Lab08Deque class
 *
 * @author Chris Szafranski
 * @version Oct 29, 2015
 */
public class Lab08DequeTest
    extends TestCase
{
    /**
     * new deque declaration
     */
    Lab08Deque<String> deck;


    // ----------------------------------------------------------
    /**
     * Create a new Lab08DequeTest object.
     */
    public Lab08DequeTest()
    {
        // empty test object
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void setUp()
    {
        deck = new Lab08Deque<String>();

    }


// ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testenqueueAtFront()
    {
        //
        deck.enqueueAtFront("cool");
        assertEquals("cool", deck.dequeueAtFront());
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testenqueueAtFrontEMPTY()
    {
        //
        deck.clear();
        assertNull(deck.dequeueAtFront());
    }


// ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testdequeueAtFront()
    {
        //
        deck.enqueueAtFront("work");
        assertEquals("work", deck.dequeueAtFront());
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testdequeueAtFrontEMPTY()
    {
        //
        deck.clear();
        assertNull(deck.dequeueAtFront());
    }


// ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testenqueueAtRearTest()
    {
        //
        deck.enqueueAtRear("boy");
        assertEquals("boy", deck.dequeueAtRear());
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testenqueueAtRearEMPTYTest()
    {
        //
        deck.clear();

    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testfrontItemTest()
    {
        //
        deck.enqueueAtFront("boy");
        assertEquals("boy", deck.frontItem());
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testfrontItemEMPTYTest()
    {
        //
        deck.enqueueAtFront("boy");
        assertNull(deck.frontItem());
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testrearItemTest()
    {
        //
        deck.enqueueAtRear("Swag");
        assertEquals("Swag", deck.rearItem());

    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testrearItemEMPTYTest()
    {
        //
        deck.enqueueAtFront("boy");
        assertNull(deck.rearItem());
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testclearTest()
    {
        //
        deck.enqueueAtFront("boy");
        deck.enqueueAtFront("it");
        deck.enqueueAtFront("is");
        deck.enqueueAtFront("cool");
        deck.clear();
        assertEquals(0, deck.size());
    }

}
