import java.util.*;






public class Solution
{

    public static
    int
    maximumMeetings
    (
        int []start
        , int []end
    )
    {
        int n = end.length;
        int[][] meetings = new int[n][2];


        for
        (
            int i = 0
            ; i < n
            ; i ++
        )
        {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }

        
        Arrays.sort( meetings, new MeetingComparator() );
        int ans = 0;
        int o = -1;


        for
        (
            int[] meeting
            : meetings
        )
        {

            if
            (
                meeting[0] > o
            )
            {
                o = meeting[1];
                ans ++;
            }

        }


        return ans;
    }

}






class MeetingComparator
implements Comparator < int[] >
{

    @Override
    public
    int
    compare
    (
        int[] x
        , int[] y
    )
    {
        return Integer.compare( x[1], y[1] );
    }

}
