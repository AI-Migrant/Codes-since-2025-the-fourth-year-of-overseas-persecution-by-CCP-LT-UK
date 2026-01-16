import java.util.*;




public class Solution
{

    public static
    int
    minRemovals
    (
        int n
        , int [] prices
    )
    {
        return solve( new int [ n ], prices, 0, 0 );
    }




    static
    int
    solve
    (
        int [] cache
        , int [] prices
        , int i
        , int k
    )
    {

        if
        (
            i == prices.length
        )
        {
            return 0;
        }
        else if
        (
            prices[i] < k
        )
        {
            cache[i] = 1 + solve( cache, prices, i + 1, k );
        }
        else
        {
            cache[i] = Math.min
                (
                    solve( cache, prices, i + 1, prices[i] )
                    , 1 + solve( cache, prices, i + 1, k )
                );
        }

        
        return cache[i];
    }

}
