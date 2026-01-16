import java.util.*;





public class Solution
{

    public static
    int
    stringBreaker
    (
        String s
        , int n
        , String[] dictionary
    )
    {
        int ans = solve( new int[s.length()], dictionary, s, 0 );

        if
        (
            ans < 0
        )
        {
            return ans;
        }
        else
        {
            return ans - 1;
        }
        
    }





    static
    int
    solve
    (
        int[] c
        , String[] d
        , String s
        , int i
    )
    {
        
        if
        (
            i == s.length()
        )
        {
            return 0;
        }
        else if
        (
            c[i] != 0
        )
        {
            return c[i];
        }

        int ans = 50;


        for
        (
            String w
            : d
        )
        {

            if
            (
                s.substring( i ).startsWith( w )
            )
            {
                int k = solve( c, d, s, i + w.length() );

                if
                (
                    k >= 0
                )
                {
                    ans = Math.min( ans, k );
                }

            }
            
        }


        if
        (
            ans == 50
        )
        {
            c[i] = -1;
        }
        else
        {
            c[i] = ans + 1;
        }
        
        return c[i];
    }

}
