import java.util.*;






public class Solution
{

    public static
    double
    calculateArea
    (
        int n
        , int points[][]
    )
    {
        double ans = 0;


        for
        (
            int i = 0
            ; i < n
            ; i ++
        )
        {


            for
            (
                int j = i + 1
                ; j < n
                ; j ++
            )
            {
                double a = getLength( points[i], points[j] );


                for
                (
                    int k = j + 1
                    ; k < n
                    ; k ++
                )
                {
                    double b = getLength( points[i], points[k] );
                    double c = getLength( points[j], points[k] );
                    Double area = getArea( a, b, c );
                    
                    if
                    (
                        !area.isNaN()
                    )
                    {
                        ans = Math.max( ans, area );
                    }

                }


            }


        }


        return ans;
    }




    static
    double
    getLength
    (
        int[] point1
        , int[] point2
    )
    {
        int x = point1[0] - point2[0];
        int y = point1[1] - point2[1];

        
        return Math.sqrt( ( x * x ) + ( y * y ) );
    }




    static
    double
    getArea
    (
        double a
        , double b
        , double c
    )
    {
        double s = ( a + b + c ) / 2;

        return Math.sqrt( s * ( s - a ) * ( s - b ) * ( s - c ) );
    }

}
