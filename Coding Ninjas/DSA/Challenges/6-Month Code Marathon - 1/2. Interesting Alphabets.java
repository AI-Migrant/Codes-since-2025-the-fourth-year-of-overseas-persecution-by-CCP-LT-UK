import java.util.*;





public class Solution
{

    public static
    ArrayList< ArrayList< Character > >
    interestingPattern
    (
        int N
    )
    {
        ArrayList< ArrayList< Character > > ans = new ArrayList<>();


        for
        (
            int i = 1
            ; i <= N
            ; i ++
        )
        {
            ArrayList< Character > list = new ArrayList<>();


            for
            (
                int j = N - i
                ; j < N
                ; j ++
            )
            {
                list.add( ( char ) ( 'A' + j ) );
            }


            ans.add( list );
        }


        return ans;
    }

}
