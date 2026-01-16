import java.util.*;





public class Solution
{

    public static
    ArrayList < Integer >
    findAllSelfDividingNumbers
    (
        int lower
        , int upper
    )
    {
        ArrayList < Integer > ans = new ArrayList <> ();


        for
        (
            int i = lower
            ; i <= upper
            ; i ++
        )
        {

            if
            (
                isOK( i )
            )
            {
                ans.add( i );
            }

        }


        return ans;
    }




    
    static
    boolean
    isOK
    (
        int i
    )
    {
        
        
        for
        (
            int j = i
            ; j > 0
            ; j /= 10
        )
        {

            if
            (
                j % 10 < 1
                || i % ( j % 10 ) > 0
            )
            {
                return false;
            }

        }


        return true;
    }

}
