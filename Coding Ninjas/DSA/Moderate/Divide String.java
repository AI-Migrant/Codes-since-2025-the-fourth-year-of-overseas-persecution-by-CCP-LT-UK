import java.util.*;





public class Solution
{

    public static
    ArrayList < String >
    divideString
    (
        String word
        , int n
    )
    {
        ArrayList < String > ans = new ArrayList <> ();
        int len = word.length();

        if
        (
            len % n > 0
        )
        {
            return ans;
        }

        int m = len / n;


        for
        (
            int i = 0
            ; i < len
            ; i += m
        )
        {
            ans.add( word.substring( i, i + m ) );
        }


        return ans;
    }

}
