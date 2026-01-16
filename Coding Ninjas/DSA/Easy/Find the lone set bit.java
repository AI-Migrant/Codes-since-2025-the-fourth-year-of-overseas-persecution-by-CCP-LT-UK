import java.util.*;





public class Solution
{

    public static
    int
    findSetBit
    (
        int n
    )
    {

        if
        (
            n < 2
        )
        {
            return -1;
        }


        int ans = 2;


        while
        (
            n > 2
        )
        {

            if
            (
                n % 2 > 0
            )
            {
                return -1;
            }

            n /= 2;
            ans ++;
        }


        return ans;
    }

}
