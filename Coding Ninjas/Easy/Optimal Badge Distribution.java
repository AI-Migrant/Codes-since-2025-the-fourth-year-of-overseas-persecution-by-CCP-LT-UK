import java.util.*;




public class Solution
{

    public static
    int
    minBadges
    (
        int n
        , int [] scores
    )
    {
        return ( int ) ( Arrays.stream( scores ).distinct().count() );
    }

}
