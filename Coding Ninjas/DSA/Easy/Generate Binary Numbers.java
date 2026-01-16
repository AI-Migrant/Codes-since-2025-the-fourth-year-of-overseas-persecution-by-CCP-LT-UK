import java.util.*;





public class Solution
{

    public static
    List<String>
    generateBinaryNumbers
    (
        int n
    )
    {
        ArrayList< String > ans = new ArrayList<>();


        for
        (
            int i = 1
            ; i <= n
            ; i ++
        )
        {
            ans.add( Integer.toBinaryString( i ) );
        }


        return ans;
    }

}
