public class Solution
{

    public static
    int
    minimumSwap
    (
        int[] arr
        , int n
    )
    {
        int m = n - 1;
        int[] j = new int[2];
        int[] k = new int[2];


        for
        (
            int i = 0
            ; i < n
            ; i ++
        )
        {
            k[arr[i]] += i - j[arr[i]];
            j[arr[i]] ++;
        }


        return Math.min( k[0], k[1] );
    }

}
