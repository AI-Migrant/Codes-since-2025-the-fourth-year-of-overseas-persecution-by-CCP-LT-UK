import java.util.*;





public class Solution
{

    public static
    int[]
    shortestPath
    (
        int n
        , int [][]edges
        , int src
    )
    {
        int[] ans = new int[n];
        Arrays.fill( ans, -1 );
        HashMap < Integer, HashSet < Integer > > map = new HashMap <> ();


        for
        (
            int[] edge
            : edges
        )
        {

            if
            (
                !map.containsKey( edge[0] )
            )
            {
                map.put( edge[0], new HashSet() );
            }

            if
            (
                !map.containsKey( edge[1] )
            )
            {
                map.put( edge[1], new HashSet() );
            }

            map.get( edge[0] ).add( edge[1] );
            map.get( edge[1] ).add( edge[0] );
        }


        ans[src] = 0;
        ArrayDeque < Integer > dq = new ArrayDeque <> ();
        dq.offer( src );


        for
        (
            int i = 1
            ; !dq.isEmpty()
            ; i ++
        )
        {
            int m = dq.size();


            for
            (
                int j = 0
                ; j < m
                ; j ++
            )
            {
                int next = dq.pollFirst();

                
                for
                (
                    int k
                    : map.get( next )
                )
                {
                    
                    if
                    (
                        ans[k] >= 0
                    )
                    {
                        continue;
                    }

                    dq.offerLast( k );
                    ans[k] = i;
                }


            }


        }


        ans[src] = 0;


        return ans;
    }

}
