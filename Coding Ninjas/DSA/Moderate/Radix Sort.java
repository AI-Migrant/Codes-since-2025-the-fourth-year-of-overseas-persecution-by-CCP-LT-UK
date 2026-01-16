import java.util.*;





public class Solution
{

    static
    int[]
    radixSort
    (
        int n
        , int[] arr
    )
    {
        int[][][] mat = new int[2][10][n];
        int max = push( mat, arr );
        sort( mat, arr, max, 10 );
        pop( mat, arr );


        return arr;
    }





    static
    int
    push
    (
        int[][][] mat
        , int[] arr
    )
    {
        int[] idx = new int[10];
        int max = 0;


        for
        (
            int num
            : arr
        )
        {
            int i = num % 10;
            mat[0][i][idx[i]] = num;
            idx[i] ++;
            max = Math.max( max, num );
        }


        return max;
    }





    static
    void
    sort
    (
        int[][][] mat
        , int[] arr
        , int max
        , int m
    )
    {
        
        if
        (
            max < m
        )
        {
            return;
        }

        int[] idx = new int[10];


        for
        (
            int[] a
            : mat[0]
        )
        {


            for
            (
                int j = 0
                ; a[j] > 0
                ; j ++
            )
            {//System.out.print( a[j] + " " );
                int i = ( a[j] / m ) % 10;

                mat[1][i][idx[i]] = a[j];
                a[j] = 0;
                idx[i] ++;
            }//System.out.println();


        }


        int[][] temp = mat[1];
        mat[1] = mat[0];
        mat[0] = temp;
        pop( mat, arr );
        sort( mat, arr, max, m * 10 );
    }





    static
    void
    pop
    (
        int[][][] mat
        , int[] arr
    )
    {
        int i = 0;


        for
        (
            int[] a
            : mat[0]
        )
        {

            
            for
            (
                int num
                : a
            )
            {

                if
                (
                    num < 1
                )
                {
                    break;
                }

                arr[i] = num;
                i ++;
            }


        }

        
    }

}
