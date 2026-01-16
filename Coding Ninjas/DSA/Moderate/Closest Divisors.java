import java.util.*;





public class Solution 
{
    
    public static
    ArrayList < Integer >
    closestDivisors
    (
        int num
    )
    {
        int m = num + 1;
        int n = num + 2;
        int first = ( int ) ( Math.ceil( Math.sqrt( m ) ) );
        int second = first;
        int p = first * second;
        ArrayList < Integer > ans = new ArrayList <> ();



        while
        (
            p < m
            || p > n
        )
        {

            if
            (
                p < m
            )
            {
                second ++;
            }
            else
            {
                first --;
            }

            p = first * second;
        }


        ans.add( first );
        ans.add( second );


        return ans;
    }

}

