import java.util.*;





public class Solution
{

    public static
    void
    immediateSmaller
    (
        int []a
    )
    {
        int n = a.length;


        for
        (
            int i = 1
            ; i < n
            ; i ++
        )
        {

            if
            (
                a[i] < a[i - 1]
            )
            {
                a[i - 1] = a[i];
            }
            else
            {
                a[i - 1] = -1;
            }

        }


        a[n - 1] = -1;
    }

}
