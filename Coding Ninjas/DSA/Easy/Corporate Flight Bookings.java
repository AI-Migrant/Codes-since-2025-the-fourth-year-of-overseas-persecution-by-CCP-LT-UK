import java.util.*;





public class Solution
{

    public static
    ArrayList < Integer >
    corpFlightBookings
    (
        ArrayList < ArrayList < Integer > > bookings
        , int n
    )
    {
        int[] arr = new int[n + 1];
        ArrayList< Integer > ans = new ArrayList<>();
        int k = 0;


        for
        (
            ArrayList< Integer > booking
            : bookings
        )
        {
            arr[booking.get( 0 ) - 1] += booking.get( 2 );
            arr[booking.get( 1 )] -= booking.get( 2 );
        }


        for
        (
            int i = 0
            ; i < n
            ; i ++
        )
        {
            k += arr[i];
            ans.add( k );
        }


        return ans;
    }

}
