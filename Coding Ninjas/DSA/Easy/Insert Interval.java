import java.util.*;





public class Solution 
{

    public static
    ArrayList < ArrayList < Integer > >
    insertInterval
    (
        ArrayList < ArrayList < Integer > > intervals
        , ArrayList < Integer > newInterval
    )
    {
        int n = intervals.size();

        if
        (
            newInterval.get( 0 ) > intervals.get( n - 1 ).get( 1 )
        )
        {
            intervals.add( newInterval );


            return intervals;
        }

        ArrayList < ArrayList < Integer > > ans = new ArrayList <> ();
        int i = 0;


        while
        (
            i < n
        )
        {

            if
            (
                intervals.get( i ).get( 0 ) > newInterval.get( 1 )
                || intervals.get( i ).get( 1 ) < newInterval.get( 0 )
            )
            {
                ans.add( intervals.get( i ) );
                i ++;
            }
            else
            {
                newInterval.set( 0, Math.min
                    (
                        newInterval.get( 0 )
                        , intervals.get( i ).get( 0 )
                    )
                );


                while
                (
                    i < n
                    && newInterval.get( 1 ) >= intervals.get( i ).get( 0 )
                )
                {
                    newInterval.set( 1, Math.max
                        (
                            newInterval.get( 1 )
                            , intervals.get( i ).get( 1 )
                        )
                    );

                    i ++;
                }


                ans.add( newInterval );
            }


        }


        return ans;
    }

}
