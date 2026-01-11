class Solution
{

    public
    int
    maximalRectangle
    (
        char [][] matrix
    )
    {
        final int m = matrix.length;
        final int n = matrix[0].length;
        int answer = 0;
        final int [][][] mat = new int [ m ][ n ][ 2 ];

        if
        (
            matrix[0][0] == '1'
        )
        {
            mat[0][0][0] = 1;
            mat[0][0][1] = 1;
            answer = 1;
        }


        for
        (
            int i = 1
            ; i < m
            ; i ++
        )
        {
            if
            (
                matrix[i][0] == '1'
            )
            {
                mat[i][0][0] = mat[i - 1][0][0] + 1;
                mat[i][0][1] = 1;
                answer = Math.max( answer, mat[i][0][0] );
            }

        }


        for
        (
            int i = 1
            ; i < n
            ; i ++
        )
        {

            if
            (
                matrix[0][i] == '1'
            )
            {
                mat[0][i][0] = 1;
                mat[0][i][1] = mat[0][i - 1][1] + 1;
                answer = Math.max( answer, mat[0][i][1] );
            }

        }


        for
        (
            int i = 1
            ; i < m
            ; i ++
        )
        {


            for
            (
                int j = 1
                ; j < n
                ; j ++
            )
            {

                if
                (
                    matrix[i][j] == '1'
                )
                {
                    mat[i][j][0] = mat[i - 1][j][0] + 1;
                    mat[i][j][1] = mat[i][j - 1][1] + 1;
                    

                    for
                    (
                        int k = i
                            , c = 200
                        ; k >= 0
                            && mat[k][j][1] != 0
                        ; k --
                    )
                    {
                        c = Math.min( c, mat[k][j][1] );
                        answer = Math.max( answer, ( i - k + 1 ) * c );
                    }

                    
                }

            }

            
        }


        return answer;
    }

}
