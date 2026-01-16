import java.util.*;






public class Solution
{

    public static
    int
    minChocolatePiece
    (
        ArrayList < Integer > x
        , ArrayList < Integer > y
        , int m
        , int n
    )
    {
        int ans = 0;
        int p = 1;
        int q = 1;
        x.sort( Comparator.naturalOrder() );
        y.sort( Comparator.naturalOrder() );

        
        while
        (
            !x.isEmpty()
            && !y.isEmpty()
        )
        {

            if
            (
                x.get( x.size() - 1 ) > y.get( y.size() - 1 )
            )
            {
                ans += x.remove( x.size() - 1 ) * p;
                q ++;
            }
            else
            {
                ans += y.remove( y.size() - 1 ) * q;
                p ++;
            }

        }


        while
        (
            !x.isEmpty()
        )
        {
            ans += x.remove( x.size() - 1 ) * p;
        }


        while
        (
            !y.isEmpty()
        )
        {
            ans += y.remove( y.size() - 1 ) * q;
        }


        return ans;
    }

}
