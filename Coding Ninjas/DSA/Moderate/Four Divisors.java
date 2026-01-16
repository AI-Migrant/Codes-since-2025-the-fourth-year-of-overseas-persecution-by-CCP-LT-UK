import java.util.*;





public class Solution
{

    public static
    int
    sumFourDivisors
    (
        ArrayList< Integer > arr
        , int n
    )
    {
        HashMap< Integer, Integer > map = new HashMap<>();
        int ans = 0;


        for
        (
            int num
            : arr
        )
        {
            
            if
            (
                !map.containsKey( num )
            )
            {
                map.put( num, getSum( num ) );
            }
            
            ans += map.get( num );
        }


        return ans;
    }





    static
    int
    getSum
    (
        int num
    )
    {
        int sum = 1 + num;
        int c = 2;
        int i = 2;
        int j = num / 2;


        while
        (
            i < j
            && c < 5
        )
        {

            
            if
            (
                num % i < 1
            )
            {
                j = num / i;

                if
                (
                    i != j
                )
                {
                    c ++;
                }

                sum += i + j;
                c ++;
            }

            i ++;
        }


        if
        (
            c == 4
        )
        {
            return sum;
        }
        else
        {
            return 0;
        }

    }
}

