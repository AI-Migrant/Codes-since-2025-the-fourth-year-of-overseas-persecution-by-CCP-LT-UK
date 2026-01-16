import java.util.*;





public class Solution
{

    public static
    int
    rounds
    (
        int a
        ,int b
    )
    {
        int ans = 0;


        while
        (
            a > b
        )
        {
            int c = a;


            for
            (
                int i = 2
                ; c > 1
                ; i ++
            )
            {


                while
                (
                    c % i < 1
                )
                {
                    c /= i;
                    ans ++;
                }


            }

            
            a --;
        }


        return ans;
    }

}
