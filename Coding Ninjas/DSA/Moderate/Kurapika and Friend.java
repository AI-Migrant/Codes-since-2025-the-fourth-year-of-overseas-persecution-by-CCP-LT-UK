
import java.util.*;






public class Solution
{

    public static
    int
    maxFriends
    (
        int n
        , int[] s
        , int[] e
    )
    {
        int[][] dates = new int[n][2];
        int ans = 0;
        int f = 0;
        int i = 0;
        int j = 0;
        Arrays.sort( s );
        Arrays.sort( e );


        while
        (
            i < n
        )
        {


            while
            (
                e[j] < s[i]
            )
            {
                f --;
                j ++;
            }

            f ++;
            i ++;
            ans = Math.max( ans, f );
        }
        

        return ans;
    }

}
