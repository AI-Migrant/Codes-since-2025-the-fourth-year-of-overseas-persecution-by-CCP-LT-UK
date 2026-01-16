import java.util.*;





public class Solution 
{

    public static
    int
    uniqueSubstrings
    (
        String input
    ) 
    {
        HashMap < Character, Integer > map = new HashMap <> ();
        int ans = 0;
        int n = input.length();
        int i = 0;
        char[] arr = input.toCharArray();


        for
        (
            int j = 0
            ; j < n
            ; j ++
        )
        {
            
            map.put( arr[j], map.getOrDefault( arr[j], 0 ) + 1 );


            while
            (
                map.get( arr[j] ) > 1
            )
            {
                map.put( arr[i], map.get( arr[i] ) - 1 );
                i ++;
            }


            ans = Math.max( ans, j - i );
        }


        return ans + 1;
    }

}
