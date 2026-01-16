public class Solution
{

    public static
    int
    maxPoints
    (
        int []arr
        , int K
    )
    {
        int sum = 0;
        
        
        for
        (
            int i = 0
            ; i < K
            ; i ++
        )
        {
            sum += arr[i];
        }


        int ans = sum;


        for
        (
            int i = 0
            ; i < K
            ; i ++
        )
        {
            sum -= arr[K - i - 1];
            sum += arr[arr.length - i - 1];
            ans = Math.max( ans, sum );
        }


        return ans;
    }

}
