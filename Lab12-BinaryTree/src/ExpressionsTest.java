import student.TestCase;

// -------------------------------------------------------------------------
/**
 * This class will test the output of the main method
 *
 * @author Chris
 * @version Nov 11, 2015
 */
public class ExpressionsTest
    extends TestCase
{
    /**
     * This is a freakin Expressions class object
     */
    Expressions ex;


    /*
     * BinaryTree<String> rt; BinaryTree<String> n1; BinaryTree<String> n2;
     * BinaryTree<String> n3; BinaryTree<String> n4; BinaryTree<String> n5;
     * BinaryTree<String> n6; BinaryTree<String> n7; BinaryTree<String> n8;
     */

    // ----------------------------------------------------------
    /**
     * Setup to test main method Supression of static access needed
     */

    @SuppressWarnings("static-access")
    public void setUp()
    {
        ex = new Expressions();
        ex.main(null);
        /*
         * rt = new BinaryTree<String>("*"); n1 = new BinaryTree<String>("-");
         * n2 = new BinaryTree<String>("/"); n3 = new BinaryTree<String>("a");
         * n4 = new BinaryTree<String>("b"); n5 = new BinaryTree<String>("+");
         * n6 = new BinaryTree<String>("e"); n7 = new BinaryTree<String>("c");
         * n8 = new BinaryTree<String>("d"); rt.setLeft(n1); rt.setRight(n2);
         * n1.setLeft(n3); n1.setRight(n4); n2.setLeft(n5); n2.setRight(n6);
         * n5.setLeft(n7); n5.setRight(n8);
         */

    }


    // ----------------------------------------------------------
    /**
     * This method will test the main method
     */
    public void testMain()
    {
/*
 * assertEquals( "(((a) (b) -) (((c) (d) +) (e) /) *)", rt.toPostOrderString());
 * assertEquals( "(*(-(a) (b) ) (/(+(c) (d) ) (e) ) )", rt.toPreOrderString());
 * assertEquals( "(((a) -(b) ) *(((c) +(d) ) /(e) ) )", rt.toInOrderString());
 */
        assertTrue(systemOut().getHistory().contains(
            "(((a) (b) -) (((c) (d) +) (e) /) *)"));
        assertTrue(systemOut().getHistory().contains(
            "(*(-(a) (b) ) (/(+(c) (d) ) (e) ) )"));
        assertTrue(systemOut().getHistory().contains(
            "(((a) -(b) ) *(((c) +(d) ) /(e) ) )"));

    }

}
