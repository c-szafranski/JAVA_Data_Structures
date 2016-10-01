// -------------------------------------------------------------------------
/**
 * This class will construct a binary tree to match the traversal of
 * ((a-b)*(c+d)/e)
 *
 * @author Chris Szafranski
 * @version Nov 11, 2015
 */
public class Expressions
{
// ----------------------------------------------------------
/**
 * Fucking stupid
 */
    public Expressions() {
            // nothing here
    }


    // ----------------------------------------------------------
    /**
     * Main Method to traverse traversals
     *
     * @param args
     *            no args needed
     */
    public static void main(String[] args)
    {
        BinaryTree<String> rt = new BinaryTree<String>("*");
        BinaryTree<String> n1 = new BinaryTree<String>("-");
        BinaryTree<String> n2 = new BinaryTree<String>("/");
        BinaryTree<String> n3 = new BinaryTree<String>("a");
        BinaryTree<String> n4 = new BinaryTree<String>("b");
        BinaryTree<String> n5 = new BinaryTree<String>("+");
        BinaryTree<String> n6 = new BinaryTree<String>("e");
        BinaryTree<String> n7 = new BinaryTree<String>("c");
        BinaryTree<String> n8 = new BinaryTree<String>("d");
        rt.setLeft(n1);
        rt.setRight(n2);
        n1.setLeft(n3);
        n1.setRight(n4);
        n2.setLeft(n5);
        n2.setRight(n6);
        n5.setLeft(n7);
        n5.setRight(n8);

        String str = rt.toPostOrderString();
        System.out.println(str);
        String str2 = rt.toInOrderString();
        System.out.println(str2);
        String str3 = rt.toPreOrderString();
        System.out.println(str3);

    }
}
