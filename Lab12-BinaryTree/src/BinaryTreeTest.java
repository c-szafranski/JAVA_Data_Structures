import student.TestCase;

// -------------------------------------------------------------------------
/**
 * BinaryTree class test class
 *
 * @author Chris
 * @version Nov 11, 2015
 */
public class BinaryTreeTest
    extends TestCase
{
    private BinaryTree<String> bt;


    // ----------------------------------------------------------
    /**
     * Set up for tests
     */
    public void setUp()
    {
        bt = new BinaryTree<String>("Hello");
    }


    // ----------------------------------------------------------
    /**
     * Testing the specific constructor
     */
    public void testConstructor()
    {
        BinaryTree<String> left = new BinaryTree<String>("left");
        BinaryTree<String> right = new BinaryTree<String>("right");
        BinaryTree<String> rt = new BinaryTree<String>("root", left, right);
        assertEquals("root", rt.getElement());
        assertEquals("left", rt.getLeft().getElement());
        assertEquals("right", rt.getRight().getElement());
    }


    // ----------------------------------------------------------
    /**
     * Tests getElement() method
     */
    public void testGetElement()
    {
        String word = bt.getElement();
        assertEquals(word, bt.getElement());
    }


    // ----------------------------------------------------------
    /**
     * Tests the getElement() method
     */
    public void testSetElement()
    {
        String word = "newWord";
        bt.setElement(word);
        assertEquals(word, bt.getElement());
    }


    // ----------------------------------------------------------
    /**
     * Tests setLeft() method
     */
    public void testSetLeft()
    {
        BinaryTree<String> left = new BinaryTree<String>("left");
        bt.setLeft(left);
        assertEquals("left", left.getElement());
    }


    // ----------------------------------------------------------
    /**
     * Tests setLeft() method
     */
    public void testGetLeft()
    {
        BinaryTree<String> left = new BinaryTree<String>("left");
        bt.setLeft(left);
        assertEquals("left", bt.getLeft().getElement());
    }


    // ----------------------------------------------------------
    /**
     * Tests setRight() method
     */
    public void testSetRight()
    {
        BinaryTree<String> right = new BinaryTree<String>("right");
        bt.setLeft(right);
        assertEquals("right", right.getElement());
    }


    // ----------------------------------------------------------
    /**
     * Tests getRight() method
     */
    public void testGetRight()
    {
        BinaryTree<String> right = new BinaryTree<String>("right");
        bt.setRight(right);
        assertEquals("right", bt.getRight().getElement());
    }


    // ----------------------------------------------------------
    /**
     * Tests the size() method
     */
    public void testSize()
    {
        BinaryTree<String> right = new BinaryTree<String>("right");
        bt.setRight(right);
        BinaryTree<String> left = new BinaryTree<String>("left");
        bt.setLeft(left);
        assertEquals(3, bt.size());

    }


    // ----------------------------------------------------------
    /**
     * Tests the height method
     */
    public void testHeight()
    {
        BinaryTree<String> right = new BinaryTree<String>("right");
        bt.setRight(right);
        BinaryTree<String> left = new BinaryTree<String>("left");
        bt.setLeft(left);
        assertEquals(2, bt.height());
    }


    // ----------------------------------------------------------
    /**
     * Testing the clone() method
     */
    public void testClone()
    {
        BinaryTree<String> right = new BinaryTree<String>("right");
        bt.setRight(right);
        BinaryTree<String> left = new BinaryTree<String>("left");
        bt.setLeft(left);
        BinaryTree<String> clone = bt.clone();
        assertEquals("Hello", clone.getElement());
        assertEquals("left", clone.getLeft().getElement());
        assertEquals("right", clone.getRight().getElement());
    }


    // ----------------------------------------------------------
    /**
     * Tests the toPreOrderString() method
     */
    public void testPreOrderString()
    {
        BinaryTree<String> left = new BinaryTree<String>("left");
        BinaryTree<String> right = new BinaryTree<String>("right");
        BinaryTree<String> left1 = new BinaryTree<String>("left1");
        BinaryTree<String> right1 = new BinaryTree<String>("right1");
        bt.setLeft(left);
        bt.setRight(right);
        right.setRight(right1);
        right.setLeft(left1);

        System.out.println(bt.toPreOrderString());

        assertEquals("Hello left right left1 right1 ", bt.toPreOrderString());
    }


    // ----------------------------------------------------------
    /**
     * Tests the toPreOrderString() method
     */
    public void testInOrderString()
    {
        BinaryTree<String> left = new BinaryTree<String>("left");
        BinaryTree<String> right = new BinaryTree<String>("right");
        BinaryTree<String> left1 = new BinaryTree<String>("left1");
        BinaryTree<String> right1 = new BinaryTree<String>("right1");
        bt.setLeft(left);
        bt.setRight(right);
        right.setRight(right1);
        right.setLeft(left1);

        System.out.println(bt.toInOrderString());

        assertEquals(
            "((left) Hello((left1) right(right1) ) )",
            bt.toInOrderString());
    }


    // ----------------------------------------------------------
    /**
     * Tests postOrderString() method
     */
    public void testPostOrderString()
    {

        BinaryTree<String> left = new BinaryTree<String>("left");
        BinaryTree<String> right = new BinaryTree<String>("right");
        BinaryTree<String> left1 = new BinaryTree<String>("left1");
        BinaryTree<String> right1 = new BinaryTree<String>("right1");
        bt.setLeft(left);
        bt.setRight(right);
        right.setRight(right1);
        right.setLeft(left1);

        assertEquals(
            "((left) ((left1) (right1) right) Hello)",
            bt.toPostOrderString());

    }

}
