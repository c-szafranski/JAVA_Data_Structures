import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests the methods found in the BinarySearchTree() class
 *
 * @author Chris Szafranski
 * @version Nov.17.2015
 */
public class BinarySearchTreeTest
    extends TestCase
{
    /**
     * tree object
     */
    BinarySearchTree<String> tree;


    // ----------------------------------------------------------
    /**
     * Tests setUp() method
     */
    public void setUp()
    {
        tree = new BinarySearchTree<String>();
        tree.insert("a");
        tree.insert("aa");
        tree.insert("aaa");
        tree.insert("aaaa");
        tree.insert("aaaaa");
        tree.insert("aaaaaa");
        tree.insert("aaaaaaa");
        // seven new tree elements for a balenced tree

    }


    // ----------------------------------------------------------
    /**
     * Tests the FindMax() method
     */
    public void testFindMax()
    {
        tree.remove("aaaaaaa");
        assertEquals("aaaaaa", tree.findMax());
    }


    // ----------------------------------------------------------
    /**
     * testing insert() method
     */
    public void testInsert()
    {
        Exception thrown = null;
        try
        {
            tree.insert("aaaa"); // this item already exists
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof DuplicateItemException);
        assertEquals("aaaa", tree.find("aaaa"));
        tree.insert("aaabb"); // trying to hit that part of insert not yet
// tested
        BinarySearchTree<String> tree2;
        tree2 = new BinarySearchTree<String>();
        tree2.insert("1111111");
        tree2.insert("111");
        tree2.insert("111111111111");
        tree2.insert("1");
        tree2.insert("111111");
        assertEquals("111111", tree2.find("111111"));

    }


    // ----------------------------------------------------------
    /**
     * testing insert() method
     */
    public void testRemove()
    {
        Exception thrown = null;
        try
        {
            tree.remove("bb"); // this item already exists
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof ItemNotFoundException);
        assertNull(tree.find("bb"));
        tree.remove("aa"); // trying to hit that part of remove not yet tested
        tree.remove("aaaaa");
        BinarySearchTree<String> tree2;
        tree2 = new BinarySearchTree<String>();
        tree2.insert("1111111");
        tree2.insert("111");
        tree2.insert("111111111111");
        tree2.insert("1");
        tree2.insert("111111");
        assertEquals("111111", tree2.find("111111"));
        tree2.remove("111111111111");
        tree2.remove("1");
        tree2.remove("111111");
        tree2.remove("1111111");
        tree2.remove("111");
        assertTrue(tree2.isEmpty());
        BinarySearchTree<Integer> tree3;
        tree3 = new BinarySearchTree<Integer>();
        tree3.insert(1);
        tree3.insert(2);
        tree3.insert(3);

        tree3.remove(1);
        tree3.insert(1);

        tree3.remove(3);
        tree3.insert(3);

        tree3.remove(2);
        tree3.insert(2);

        // tree3.remove(1);
        tree3.remove(2);
        tree3.remove(3);
        // assertTrue(tree3.isEmpty());
        BinarySearchTree<Integer> tree4;
        tree4 = new BinarySearchTree<Integer>();
        tree4.insert(1);
        tree4.remove(1);
        assertTrue(tree4.isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * Tests the FindMin() method
     */
    public void testFindMin()
    {
        assertEquals("a", tree.findMin());
        tree.remove("a");
        assertEquals("aa", tree.findMin());
    }


    // ----------------------------------------------------------
    /**
     * tests find() method
     */
    public void testFind()
    {
        tree.remove("aaaaaaa");
        assertNull(tree.find("aaaaaaa"));
        assertEquals("aaaaa", tree.find("aaaaa"));
    }


    // ----------------------------------------------------------
    /**
     * Tests isEmpty() method
     */
    public void testIsEmpty()
    {
        assertFalse(tree.isEmpty());
        tree.remove("a");
        tree.remove("aa");
        tree.remove("aaa");
        tree.remove("aaaa");
        tree.remove("aaaaa");
        tree.remove("aaaaaa");
        tree.remove("aaaaaaa");
        assertTrue(tree.isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * Tests null cases of binary search tree methods
     */
    public void testNull()
    {
        tree.makeEmpty();
        assertTrue(tree.isEmpty());
        assertNull(tree.findMax());
        assertNull(tree.findMin());
    }

}
