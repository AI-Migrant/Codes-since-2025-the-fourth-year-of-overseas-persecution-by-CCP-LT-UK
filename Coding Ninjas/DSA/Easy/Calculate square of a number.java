import java.util.*;






public class Solution 
{

    public static
    int
    calculateSquare
    (
        int num
    ) 
    {
        int ans = 0;
        num = Math.abs( num );


        for
        (
            int i = 0
            ; i < 14
            ; i ++
        )
        {

            if
            (
                ( num & ( 1 << i ) ) > 0
            )
            {
                ans += num << i;
            }

        }


        return ans;
    }

}
