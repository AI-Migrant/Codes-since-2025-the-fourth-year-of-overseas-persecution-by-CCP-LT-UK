import java.util.*;





public class Solution
{

    public static
    String[]
    printPatt
    (
        int n
    )
    {
        String[] ans = new String[n];


        for
        (
            int i = 0
            ; i < n
            ; i ++
        )
        {
            ans[i] = "*".repeat( n - i );
        }


        return ans;
    }

}
