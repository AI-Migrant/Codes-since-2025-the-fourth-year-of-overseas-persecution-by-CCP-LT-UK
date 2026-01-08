class Solution
{
    private int [] nums1;
    private int [] nums2;
    private int length1;
    private int length2;
    private int [][] cache;




    public
    int
    maxDotProduct
    (
        int [] nums1
        , int [] nums2
    )
    {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.length1 = nums1.length;
        this.length2 = nums2.length;
        this.cache = new int [ length1 ][ length2 ];


        for
        (
            int i = 0
            ; i < length1
            ; i ++
        )
        {
            Arrays.fill( cache[i], Integer.MIN_VALUE );
        }


        solve( 0, 0 );

        if
        (
            cache[0][0] == 0
        )
        {
            return getMin( nums1 ) * getMin( nums2 );
        }
        else
        {
            return cache[0][0];
        }

    }




    private
    int
    solve
    (
        final int i
        , final int j
    )
    {

        if
        (
            i == length1
            || j == length2
        )
        {
            return 0;
        }
        else if
        (
            cache[i][j] != Integer.MIN_VALUE
        )
        {
            return cache[i][j];
        }

        final int signum1 = Integer.signum( nums1[i] );
        cache[i][j] = solve( i + 1, j );


        for
        (
            int k = j
            ; k < length2
            ; k ++
        )
        {

            if
            (
                signum1 != Integer.signum( nums2[k] )
            )
            {
                continue;
            }
            
            cache[i][j] = Math.max( cache[i][j], solve( i + 1, k + 1 ) + nums1[i] * nums2[k] );
        }


        return cache[i][j];
    }




    private
    int
    getMin
    (
        final int [] nums
    )
    {
        int minIndex = 0;
        int min = Integer.MAX_VALUE;


        for
        (
            int i = 0
            ; i < nums.length
            ; i ++
        )
        {
            final int value = Math.abs( nums[i] );

            if
            (
                value < min
            )
            {
                min = value;
                minIndex = i;
            }

        }


        return nums[minIndex];
    }

}
