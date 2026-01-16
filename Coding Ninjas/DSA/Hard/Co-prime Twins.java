import java.util.*;






public class Solution
{

    public static
    int[]
    coprimeTwins
    (
        int[] a
        , int[][] queries
    )
    {
        int n = a.length;
        int m = queries.length;
        HashMap < Integer, HashSet < Integer > > map = new HashMap <> ();
        int[][] arr = new int[n][n];
        int[] ans = new int[m];


        for
        (
            int i
            : a
        )
        {
            
            if
            (
                !map.containsKey( i )
            )
            {
                map.put( i, getPrimes( i ) );
            }

        }


        for
        (
            int i = 0
            ; i < n
            ; i ++
        )
        {

            
            for
            (
                int j = i + 1
                ; j < n
                ; j ++
            )
            {
                
                if
                (
                    map.get( a[i] ).equals( map.get( a[j] ) )
                )
                {
                    arr[i][j] = arr[i][j - 1] + 1;
                }
                else
                {
                    arr[i][j] = arr[i][j - 1];
                }

            }


        }


        for
        (
            int i = 0
            ; i < m
            ; i ++
        )
        {
            int k = queries[i][1] - 1;


            for
            (
                int j = queries[i][0] - 1
                ; j < k
                ; j ++
            )
            {
                ans[i] += arr[j][k] - arr[j][j];
            }

            
        }


        return ans;
    }




    static
    HashSet < Integer >
    getPrimes
    (
        int n
    )
    {
        HashSet < Integer > set = new HashSet <> ();
        int p = 2;


        while
        (
            p <= n
            && n > 1
        )
        {

            if
            (
                n % p < 1
            )
            {
                set.add( p );


                while
                (
                    n % p < 1
                )
                {
                    n /= p;
                }

            }

            p ++;
        }


        return set;
    }

}
