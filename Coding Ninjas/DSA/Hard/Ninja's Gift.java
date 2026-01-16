import java.util.*;





public class Solution
{

    public static
    Boolean
    canChange
    (
        String k
        , String s
    )
    {
        int n = k.length();

        if
        (
            n != s.length()
        )
        {
            return false;
        }

        char[] arr = new char[26];


        for
        (
            int i = 0
            ; i < n
            ; i ++
        )
        {
            char c = k.charAt( i );
            int j = c - 'a';

            if
            (
                arr[j] < 'a'
            )
            {
                arr[j] = s.charAt( i );
            }
            else if
            (
                arr[j] != s.charAt( i )
            )
            {
                return false;
            }

        }


        return true;
    }

}
