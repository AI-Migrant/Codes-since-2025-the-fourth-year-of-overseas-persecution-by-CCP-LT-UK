import java.util.*;




public class Solution
{

    public static
    int
    groupAllOneTogether
    (
        int arr[],
        int n
    )
    {
        int c = 0;
        int i = 0;
        int j = 0;
        int m = 0;
        int o = 0;


        for
        (
            int num
            : arr
        )
        {
            o += num;
        }


        if
        (
            o < 1
        )
        {
            return -1;
        }
        else if
        (
            o == n
        )
        {
            return 0;
        }

        
        while
        (
            j < o
        )
        {
            c += arr[j];
            j ++;
        }


        m = c;


        while
        (
            j < n
        )
        {
            c -= arr[i];
            c += arr[j];
            i ++;
            j ++;
            m = Math.max( m, c );
        }


        return o - m;
    }

}
