// -------------------------------------------------------------------------
/**
 * Stores a contact's first and last name as well as a phone number
 *
 * @author Chris
 * @version Nov 17, 2015
 */
public class Contact
    implements Comparable<Contact>
{

    private String fName;
    private String lName;
    private String phone;


    // ----------------------------------------------------------
    /**
     * Create a new Contact object.
     *
     * @param fname
     *            of type String
     * @param lname
     *            of type String
     * @param number
     *            of type String
     */
    public Contact(String fname, String lname, String number)
    {
        fName = fname;
        lName = lname;
        phone = number;
    }


    // ----------------------------------------------------------
    /**
     * Compares two contact variables
     *
     * @param o
     *            of type Contact
     * @return the comparison result
     */
    public int compareTo(Contact o)
    {
        if (o.getLast().compareTo(lName) == 0)
        {
            if (o.getFirst().compareTo(fName) == 0)
            {
                return o.getNumber().compareTo(phone);
            }
            else
            {
                return o.getFirst().compareTo(fName);
            }
        }
        else
        {
            return o.getLast().compareTo(lName);
        }
    }


    // ----------------------------------------------------------
    /**
     * get phone number.
     *
     * @return phone number
     */
    public String getNumber()
    {

        return phone;
    }


// ----------------------------------------------------------
    /**
     * get first name
     *
     * @return first name
     */
    public String getFirst()
    {

        return fName;
    }


// ----------------------------------------------------------
    /**
     * get last name
     *
     * @return last name
     */
    public String getLast()
    {

        return lName;
    }

}
