import java.util.*;




public class Solution
{

    public static
    int
    maximumSwap
    (
        int n
    )
    {
        final char [] arr = Integer.toString( n ).toCharArray();


        for
        (
            int i = 0
            ; i < arr.length
            ; i ++
        )
        {
            char max = arr[i];
            int k = 0;
            boolean t = false;

            
            for
            (
                int j = i + 1
                ; j < arr.length
                ; j ++
            )
            {
                
                if
                (
                    !t
                )
                {
                    if
                    (
                        arr[j] > max
                    )
                    {
                        max = arr[j];
                        k = j;
                        t = true;
                    }

                }
                else
                {

                    if
                    (
                        arr[j] >= max
                    )c
                    {
                        max = arr[j];
                        k = j;
                    }

                }

            }


            if
            (
                k != 0
            )
            {
                final char temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;


                return Integer.parseInt( new String( arr ) );
            }
            
        }


        return n;
    }

}
