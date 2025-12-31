class Solution
{
    private static final int [] borderIndex = { 0, 1, 2, 5, 8, 7, 6, 3 };
    private static final int [] magic = { 2, 9, 4, 3, 8, 1, 6, 7, 2, 9, 4, 3, 8, 1, 6, 7 };
    private static final int [] reverseMagic = { 7, 6, 1, 8, 3, 4, 9, 2, 7, 6, 1, 8, 3, 4, 9, 2 };
    int [][] grid;



    
    public
    int
    numMagicSquaresInside
    (
        int [][] grid
    )
    {
        this.grid = grid;
        final int m = grid.length;
        final int n = grid[0].length;
        int answer = 0;


        for
        (
            int i = 2
            ; i < m
            ; i ++
        )
        {


            for
            (
                int j = 2
                ; j < n
                ; j ++
            )
            {

                if
                (
                    isMagic( i, j )
                )
                {
                    answer ++;
                }

            }


        }


        return answer;
    }




    private
    boolean
    isMagic
    (
        final int row
        , final int col
    )
    {
        if
        (
            grid[row - 1][col - 1] != 5
            || grid[row][col] % 2 != 0
            || grid[row][col] < 1
            || grid[row][col] > 8
        )
        {
            return false;
        }

        final int [] border = new int [ 8 ];


        for
        (
            int i = 0
            ; i < 8
            ; i ++
        )
        {
            border[i] = grid[row - ( borderIndex[i] / 3 )][col - ( borderIndex[i] % 3 )];
        }


        return compare( border, magic ) || compare( border, reverseMagic );
    }




    private
    boolean
    compare
    (
        final int [] border
        , final int [] magic
    )
    {
        int j = 0;


        while
        (
            magic[j] != border[0]
        )
        {
            j ++;
        }


        int i = 0;
        

        while
        (
            i < 8
        )
        {

            if
            (
                border[i] != magic[j]
            )
            {
                break;
            }

            i ++;
            j ++;
        }


        return i == 8;
    }

}
