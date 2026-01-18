class Solution
{

    public
    int
    largestMagicSquare
    (
        int [][] grid
    )
    {
        final int m = grid.length;
        final int n = grid[0].length;
        final int [][] gridA = new int [ m + 1 ][ n + 1 ];
        final int [][] gridD = new int [ m + 1 ][ n + 1 ];
        final int [][] gridH = new int [ m ][ n + 1 ];
        final int [][] gridV = new int [ m + 1 ][ n ];


        for
        (
            int i = 0
            ; i < m
            ; i ++
        )
        {


            for
            (
                int j = 0
                ; j < n
                ; j ++
            )
            {
                gridA[i + 1][j] = gridA[i][j + 1] + grid[i][j];
                gridD[i + 1][j + 1] = gridD[i][j] + grid[i][j];
                gridH[i][j + 1] = gridH[i][j] + grid[i][j];
                gridV[i + 1][j] = gridV[i][j] + grid[i][j];
            }


        }
        

        for
        (
            int k = Math.min( m, n )
            ; k >= 1
            ; k --
        )
        {


            for
            (
                int i = 0
                ; i + k <= m
                ; i ++
            )
            {


                for
                (
                    int j = 0
                    ; j + k <= n
                    ; j ++
                )
                {
                    final int A = gridA[i + k][j] - gridA[i][j + k];

                    if
                    (
                        A != gridD[i + k][j + k] - gridD[i][j]
                    )
                    {
                        continue;
                    }

                    boolean t = true;


                    for
                    (
                        int p = i
                        ; p < i + k
                            && t
                        ; p ++
                    )
                    {

                        if
                        (
                            gridH[p][j + k] - gridH[p][j] != A
                        )
                        {
                            t = false;
                        }
                        
                    }


                    for
                    (
                        int p = j
                        ; p < j + k
                            && t
                        ; p ++
                    )
                    {

                        if
                        (
                            gridV[i + k][p] - gridV[i][p] != A
                        )
                        {
                            t = false;
                        }
                        
                    }


                    if
                    (
                        t
                    )
                    {
                        return k;
                    }

                }


            }


        }


        return 1;
    }

}
