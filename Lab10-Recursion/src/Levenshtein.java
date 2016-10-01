import java.util.HashMap;

// -------------------------------------------------------------------------
/**
 * Levenshtein distance algorithm
 *
 * @author Chris Szafranski
 * @version (2015.09.24)
 */
public class Levenshtein
{
    /**
     * initializes first string
     */
    String                   str1;
    /**
     * initializes second string
     */
    String                   str2;
    /**
     * initializes hashmap
     */
    HashMap<String, Integer> hashMap;


    // ----------------------------------------------------------
    /**
     * Create a new Levenshtein object.
     *
     * @param str1
     *            of type string
     * @param str2
     *            of type string
     */

    public Levenshtein(String str1, String str2)
    {
        this.str1 = str1;
        this.str2 = str2;
        hashMap = new HashMap<String, Integer>();
    }


    // ----------------------------------------------------------
    /**
     * recursive function to find steps in differences in strings.
     *
     * @param str1Length
     *            first string length
     * @param str2Length
     *            second string length
     * @param sp1
     *            starting position 1
     * @param sp2
     *            starting position 2
     */

    private int findInts(int str1Length, int str2Length, int sp1, int sp2)
    {

        String key = str1Length + "," + str2Length + "," + sp1 + "," + sp2;
        if (hashMap.containsKey(key))
        {
            return hashMap.get(key);
        }

        if (str1Length == 0)
        {
            return str2Length;
        }

        if (str2Length == 0)
        {
            return str1Length;
        }

        if (str1.charAt(sp1) == str2.charAt(sp2))
        {
            return 0 + findInts(
                str1Length - 1,
                str2Length - 1,
                sp1 + 1,
                sp2 + 1);
        }

        int x = findInts(str1Length - 1, str2Length - 1, sp1 + 1, sp2 + 1);
        int y = findInts(str1Length, str2Length - 1, sp1, sp2 + 1);
        int z = findInts(str1Length - 1, str2Length, sp1 + 1, sp2);

        int a = Math.min(x, Math.min(y, z)) + 1;
        hashMap.put(key, a);
        return a;
    }


    // ----------------------------------------------------------
    /**
     * runs the recursive method.
     *
     * @return find ints int
     */
    public int distance()
    {
        return findInts(str1.length(), str2.length(), 0, 0);
    }
}
