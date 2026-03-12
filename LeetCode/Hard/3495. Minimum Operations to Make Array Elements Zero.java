// 9 ms, 101 MB
class Solution
{

    public
    long
    minOperations
    (
        int[][] queries
    )
    {
        long ans = 0;


        for
        (
            int[] query
            : queries
        )
        {
            query[1] ++;
            int o = 1;
            long s = 1;


            while
            (
                query[0] > o
            )
            {
                s += query[1] - query[0];
                o *= 4;
            }


            while
            (
                query[1] > o
            )
            {
                s += query[1] - o;
                o *= 4;
            }


            ans += s / 2;
        }


        return ans;
    }

}
