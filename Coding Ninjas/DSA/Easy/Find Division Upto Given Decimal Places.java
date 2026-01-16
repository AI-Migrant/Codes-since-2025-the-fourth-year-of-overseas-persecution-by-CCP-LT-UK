import java.math.BigDecimal;
import java.math.RoundingMode;




public class Solution
{

    public static
    String
    findDivision
    (
        int x
        , int y
        , int n
    )
    {
        BigDecimal c = new BigDecimal( x );
        BigDecimal d = new BigDecimal( y );
        c = c.divide( d, n, RoundingMode.DOWN );
        String ans = c.toPlainString();

        if
        (
            (
                (
                    x > 0
                    && y < 0
                )
                ||
                (
                    x < 0
                    && y > 0
                )
            )
            &&
            !ans.startsWith( "-" )
        )
        {
            return "-" + ans;
        }
        else
        {
            return ans;
        } 

    }

}
