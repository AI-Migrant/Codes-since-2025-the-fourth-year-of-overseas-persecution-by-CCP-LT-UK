import java.util.*;





public class Solution 
{

    public static
    ArrayList< Integer >
    findTriplets
    (
        int[] arr
        , int n
    )
    {

        HashSet< Integer > set = new HashSet<>();
        ArrayList< Integer > ans = new ArrayList<>();


        for
        (
            int i
            : arr
        )
        {

            for
            (
                int j
                : set
            )
            {
                
                if
                (
                    set.contains( i + j )
                )
                {
                    ans.add( i );
                    ans.add( j );
                    ans.add( i + j );


                    return ans;
                }

                int k = Math.abs( i - j );

                if
                (
                    set.contains( k )
                    && k != j
                )
                {
                    ans.add( i );
                    ans.add( j );
                    ans.add( k );


                    return ans;
                }

            }
            

            set.add( i );
        }


        return ans;
    }

}
