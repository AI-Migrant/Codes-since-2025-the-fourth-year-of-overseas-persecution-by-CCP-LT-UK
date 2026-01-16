import java.util.*;





public class Solution
{

    public static
    Boolean
    splitString
    (
        String str
    )
    {
        int n = str.length() / 2;
        str = str.toLowerCase();
        String s = str.substring( 0, n );
        String t = str.substring( n );


        return countVowels( s ) == countVowels( t );
    }




    static
    int
    countVowels
    (
        String s
    )
    {
        char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
        int count = 0;


        for
        (
            char c
            : s.toCharArray()
        )
        {
            
            
            for
            (
                char d
                : vowels
            )
            {

                if
                (
                    c == d
                )
                {
                    count ++;

                    break;
                }

            }
            

        }


        return count;
    }

}
