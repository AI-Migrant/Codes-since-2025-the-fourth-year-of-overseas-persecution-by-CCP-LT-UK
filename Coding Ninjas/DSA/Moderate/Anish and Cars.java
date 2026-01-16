/*
    Time Complexity: O(N)
    Space Complexity: O(N)

    where N is where N is the number of cars.
*/

import java.util.*;






public class Solution
{
  
    public static
    int
    find
    (
        int n
        , int[] position
        , int[] speed
        , int d
    )
    {
        int[][] arr = new int[n][2];


        for
        (
            int i = 0
            ; i < n
            ; i ++
        )
        {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }


        Arrays.sort( arr, new CarComparator() );
        double t = 0;
        int ans = 0;


        for
        (
            int i = 0
            ; i < n
            ; i ++
        )
        {
            double c = ( ( double ) ( d - arr[i][0] ) ) / arr[i][1];
            
            if
            (
                c > t
            )
            {
                t = c;
                ans ++;
            }

        }


        return ans;

    }

}






class CarComparator
implements Comparator < int[] >
{

    @Override
    public
    int
    compare
    (
        int[] car1
        , int[] car2
    )
    {
        return Integer.compare( car2[0], car1[0] );
    }

}
