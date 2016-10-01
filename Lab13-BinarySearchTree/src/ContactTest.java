import student.TestCase;

// -------------------------------------------------------------------------
/**
 * This class will tests methods of the Contact() class
 *
 * @author Chris
 * @version Nov 17, 2015
 */
public class ContactTest
    extends TestCase
{
    private Contact contact;
    private Contact contact2;
    private Contact contact3;
    private Contact contact4;


    // ----------------------------------------------------------
    /**
     * Sets up tests
     */
    public void setUp()
    {
        contact = new Contact("Jane", "Doe", "123456789");
        contact2 = new Contact("John", "Doe", "123456789");
        contact3 = new Contact("Jane", "Doe", "123456789");
        contact4 = new Contact("Jane", "shmo", "123456789");
    }


// ----------------------------------------------------------
    /**
     * Will test all methods of the contact class
     */
    public void test()
    {
        assertEquals("Jane", contact.getFirst());
        assertEquals("Doe", contact.getLast());
        assertEquals("123456789", contact.getNumber());
        assertEquals(0, contact.compareTo(contact3));
        assertEquals(14, contact.compareTo(contact2));
        assertEquals(47, contact.compareTo(contact4));
    }
}
