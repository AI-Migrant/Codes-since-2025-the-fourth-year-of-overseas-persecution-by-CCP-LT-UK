import java.util.*;





public class Solution
{
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };





    public static
    void
    replaceOWithX
    (
        char matrix[][]
    )
    {
        int n = matrix.length;
        int m = matrix[0].length;
        char[][] mat = new char[n][m];


        for
        (
            int i = 0
            ; i < n
            ; i ++
        )
        {
            mat[i] = Arrays.copyOf( matrix[i], m );
        }
        

        for
        (
            int i = 0
            ; i < n
            ; i ++
        )
        {
            
            if
            (
                i == 0
                || i == n - 1
            )
            {


                for
                (
                    int j = 0
                    ; j < m
                    ; j ++
                )
                {
                    replace( mat, i, j );
                }


            }
            else
            {
                replace( mat, i, 0 );
                replace( mat, i, m - 1 );
            }

        }


        n --;
        m --;


        for
        (
            int i = 1
            ; i < n
            ; i ++
        )
        {
            
            
            for
            (
                int j = 1
                ; j < m
                ; j ++
            )
            {
                
                if
                (
                    mat[i][j] == 'O'
                )
                {
                    replace( matrix, i, j );
                }

            }


        }


    }





    static
    void
    replace
    (
        char[][] mat
        , int x
        , int y
    )
    {

        if
        (
            x < 0
            || x >= mat.length
            || y < 0
            || y >= mat[0].length
            || mat[x][y] == 'X'
        )
        {
            return;
        }

        mat[x][y] = 'X';


        for
        (
            int[] d
            : dir
        )
        {
            replace( mat, x + 1, y );
            replace( mat, x - 1, y );
            replace( mat, x, y + 1 );
            replace( mat, x, y - 1 );
        }

        
    }

}
