import java.util.*;






public class Solution
{

    public static
    int
    max_shares
    (
        int k
        , int n
        , int[] shares
    )
    {
        int[][] arr = new int[n][2];


        for
        (
            int i = 0
            ; i < n
            ; i ++
        )
        {
            arr[i][0] = shares[i];
            arr[i][1] = i + 1;
        }


        Arrays.sort( arr, new ShareComparator() );
        int ans = 0;


        for
        (
            int i = 0
            ; i < n
                && arr[i][0] <= k
            ; i ++
        )
        {
            int share = Math.min( arr[i][1], k / arr[i][0] );
            k -= share * arr[i][0];
            ans += share;
        }


        return ans;
    }

}






class ShareComparator
implements Comparator < int[] >
{

    @Override
    public
    int
    compare
    (
        int[] share1
        , int[] share2
    )
    {
        return Integer.compare( share1[0], share2[0] );
    }

}
