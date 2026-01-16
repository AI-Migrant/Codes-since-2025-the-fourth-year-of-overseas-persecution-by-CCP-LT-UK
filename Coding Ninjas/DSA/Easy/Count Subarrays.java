import java.util.*;





public class Solution
{

    public static
    int
    numberofSubarrays
    (
        int n
        , int[] arr
    )
    {
        int c = 0;
        int ans = 0;
        int p = -1;


        for
        (
            int num
            : arr
        )
        {

            if
            (
                p == num
            )
            {
                c ++;
            }
            else
            {
                c = 1;
                p = num;
            }

            ans += c;
        }


        return ans;
    }

}
