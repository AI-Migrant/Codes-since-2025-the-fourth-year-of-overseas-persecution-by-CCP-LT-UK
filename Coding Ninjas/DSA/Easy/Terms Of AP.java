import java.util.*;





public class Solution
{

    public static
    int[]
    termsOfAP
    (
        int x
    )
    {
        int[] ans = new int[x];
        int i = 0;
        int s = 5;
        int t = 3;


        while
        (
            i < x
        )
        {
            
            if
            (
                t % 4 > 0
            )
            {
                ans[i] = s;
                i ++;
            }

            s += 3;
            t ++;
        }


        return ans;
    }

}
