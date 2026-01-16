import java.util.*;





public class Solution
{

    public static
    int
    totalSalary
    (
        int basic
        , char grade
    )
    {
        double ans = basic * 1.59;
        

        if
        (
            grade == 'A'
        )
        {
            ans += 1700;
        }
        else if
        (
            grade == 'B'
        )
        {
            ans += 1500;
        }
        else
        {
            ans += 1300;
        }


        return ( int ) ( Math.round( ans ) );
    }

}
