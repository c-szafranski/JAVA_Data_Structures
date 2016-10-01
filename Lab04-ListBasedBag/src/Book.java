// -------------------------------------------------------------------------
/**
 * The Book class represents a simple book with a title (string), author
 * (string), and ISBN number (string).
 *
 * @author John Lewis (authored class skeleton)
 * @author Chris Szafranski
 * @version (2015.10.08)
 */
public class Book
{
    // ~ Instance/static variables .............................................

    /**
     * Title of type string
     */
    protected String title;

    /**
     * Author of type string
     */
    protected String author;

    /**
     * Book ISBN Number of type string
     */
    protected String isbn;


    // ----------------------------------------------------------
    /**
     * Creates a new Book object using the specified data.
     *
     * @param title
     *            of type string
     * @param author
     *            of type string
     * @param isbn
     *            of type string @precondition No param is null
     */
    public Book(String title, String author, String isbn)
    {

        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the book title.
     *
     * @return the title of type string
     * @postcondition returned value is not null
     */
    public String getTitle()
    {
        return title;
    }


    // ----------------------------------------------------------
    /**
     * Setter for the book title.
     *
     * @param title
     *            of type string
     * @precondition parameter is not null
     */
    public void setTitle(String title)
    {
        this.title = title;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the author name.
     *
     * @return the author of the book
     * @postcondition returned value is not null
     */
    public String getAuthor()
    {
        return author;
    }


    // ----------------------------------------------------------
    /**
     * Setter for the author name.
     *
     * @param author
     *            the new author of the book
     * @precondition parameter author is not null
     */
    public void setAuthor(String author)
    {
        this.author = author;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the ISBN number.
     *
     * @return the ISBN of the book
     * @postcondition returned value is not null
     */
    public String getIsbn()
    {
        return isbn;
    }


    // ----------------------------------------------------------
    /**
     * Setter for the ISBN number.
     *
     * @param isbn
     *            the new isbn of the book
     * @precondition parameter isbn is not null
     */
    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }


    // ----------------------------------------------------------
    /**
     * Returns a summary description of the book.
     *
     * @return a string representation of the book
     * @postcondition returned value is not null
     */
    public String toString()
    {
        return title + ", " + author + ", " + isbn;
    }


    // ----------------------------------------------------------
    /**
     * test if two books equal each other
     * 
     * @param object
     *            of type Object
     * @return boolean t/f depending on equivalence
     */
    public boolean equals(Object object)
    {
        if (object instanceof Book)
        {
            return (title.equals(((Book)object).title));
        }
        else
        {
            return false;
        }
    }
}
