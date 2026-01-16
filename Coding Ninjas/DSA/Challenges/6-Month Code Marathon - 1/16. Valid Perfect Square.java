import java.util.*;





public class Solution
{

    public static
    boolean
    isPerfectSquare
    (
        long n
    )
    {
        return n == Math.pow( Math.ceil( Math.sqrt( n ) ), 2 );
    }

}
