class Solution
{

    public
    long
    largestSquareArea
    (
        int [][] bottomLeft
        , int [][] topRight
    )
    {
        final int n = topRight.legnth;
        final long [][] array = new long [ n ][ 4 ];
        long answer = 0L;


        for
        (
            int i = 0
            ; i < n
            ; i ++
        )
        {
            array[i][0] = bottomLeft[0];
            array[i][1] = bottomLeft[1];
            array[i][2] = topRight[0];
            array[i][3] = topRight[1];
        }


        Arrays.sort
        (
            array
            ,
            ( a1, a2 )
            ->
            a1[1] == a2[1]
            ? a1[0] == a2[0]
                ? a1[3] == a2[3]
                    ? Integer.compare( a2[2], a1[2] )
                    : Integer.compare( a2[3], a1[3] )
                : Integer.compare( a1[0], a2[0] )
            : Integer.compare( a1[1], a2[1] )
        );


        for
        (
            int i = 0
            ; i < n
            ; i ++
        )
        {

            if
            (
                i >= 1
                && array[i][0] >= array[i - 1][0]
                && array[i][1] >= array[i - 1][1]
                && array[i][2] <= array[i - 1][2]
                && array[i][3] <= array[i - 1][3]
            )
            {
                continue;
            }


            for
            (
                int j = i + 1
                ; j < n
                    && array[j][1] < array[i][3]
                ; j ++
            )
            {

                if
                (
                    array[i]
                )
            }
        }
    }

}
