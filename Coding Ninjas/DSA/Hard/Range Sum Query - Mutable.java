import java.util.*;





public class RangeSumQuery
{
    int m;
    int n;
    int[] a;





    RangeSumQuery
    (
        int[] arr
    )
    {
        m = 1;
        n = arr.length;


        while
        (
            m < n
        )
        {
            m *= 2;
        }


        a = new int[m * 2];


        for
        (
            int i = 0
            ; i < n
            ; i ++
        )
        {
            change( i + m, arr[i] );
        }
        

    }





    void
    update
    (
        int ind
        , int val
    )
    {
        int i = ind + m;
        change( i, val - a[i] );
    }





    void
    change
    (
        int i
        , int v
    )
    {
        a[i] += v;
        
        if
        (
            i > 1
        )
        {
            change( i / 2, v );
        }

    }




    
    int
    sumOfRange
    (
        int l
        , int r
    )
    {
        return sum( 0, m - 1, l, r, 1 );
    }





    int
    sum
    (
        int min
        , int max
        , int l
        , int r
        , int i
    )
    {

        if
        (
            l > max
            || r < min
        )
        {
            return 0;
        }
        else if
        (
            l <= min
            && r >= max
        )
        {
            return a[i];
        }

        i *= 2;
        int o = ( min + max ) / 2;
        int p = sum( min, o, l, r, i );
        int q = sum( o + 1, max, l, r, i + 1 );


        return p + q;
    }

}
