import java.util.*;





public class Solution
{

    public static
    int
    stringMania
    (
        int n
        , int m
        , String str1
        , String str2
    )
    {
        int o = Math.min( n, m );
        


        for
        (
            int i = 0
            ; i < o
            ; i ++
        )
        {
            int j = Character.compare( str1.charAt( i ), str2.charAt( i ) );

            if
            (
                j > 0
            )
            {
                return 1;
            }
            else if
            (
                j < 0
            )
            {
                return -1;
            }

        }

        
        return Integer.compare( n, m );
    }

}
