import java.util.*;





public class Solution
{

    public static
    int
    gridOverlap
    (
        ArrayList< ArrayList < Integer > > mat1
        , ArrayList< ArrayList< Integer > > mat2
        , int n
    )
    {
        int ans = 0;
        
        
        for
        (
            int i = 0
            ; i < n
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
                ans = Math.max( ans, count( mat1, mat2, i, j ) );
            }


        }


        return ans;
    }





    static
    int
    count
    (
        ArrayList< ArrayList < Integer > > mat1
        , ArrayList< ArrayList< Integer > > mat2
        , int i
        , int j
    )
    {
        int r = 0;
        int s = 0;
        int t = 0;
        int u = 0;


        for
        (
            int p = 0
            ; p + i < mat1.size()
            ; p ++
        )
        {


            for
            (
                int q = 0
                ; q + j < mat1.size()
                ; q ++
            )
            {

                if
                (
                    mat1.get( i + p ).get( j + q ) == mat2.get ( p ).get( q )
                    && mat2.get( p ).get( q ) == 1
                )
                {
                    r ++;
                }

                if
                (
                    mat1.get( p ) .get( q ) == mat2.get( i + p ).get( j + q )
                    && mat1.get( p ).get( q ) == 1
                )
                {
                    s ++;
                }

                if
                (
                    mat1.get( i + p ).get( q ) == mat2.get( p ).get( j + q )
                    && mat1.get( i + p ).get( q ) == 1
                )
                {
                    t ++;
                }

                if
                (
                    mat1.get( p ).get( j + q ) == mat2.get( i + p ).get( q )
                    && mat1.get( p ).get( j + q ) == 1
                )
                {
                    u ++;
                }

            }


        }


        return Math.max( Math.max( r, s ), Math.max( t, u ) );
    }

}
