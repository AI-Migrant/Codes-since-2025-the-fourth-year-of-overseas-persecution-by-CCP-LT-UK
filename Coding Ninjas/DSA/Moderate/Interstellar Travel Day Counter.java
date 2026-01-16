import java.time.*;
import java.util.*;




public class Solution
{

    public
    int
    daysBetween
    (
        String start
        , String end
        , List < String [] > blocks
    )
    {
        int answer = 0;
        LocalDate prevDate = this.stringToDate( start );
        final LocalDate endDate = this.stringToDate( end );
        blocks.sort( ( b1, b2 ) -> b1[0].compareTo( b2[0] ) );


        for
        (
            String [] block
            : blocks
        )
        {
            final LocalDate blackoutEnd = stringToDate( block[1] );
            
            answer += Math.max
                (
                    0
                    , Period.between( prevDate, stringToDate( block[0] ) )
                        .getDays()
                );

            if
            (
                prevDate.compareTo( blackoutEnd ) < 0
            )
            {
                prevDate = blackoutEnd;
            }

        }

        
        return answer + Math.max
            (
                0
                , Period.between( prevDate, endDate ).getDays()
            );
    }




    private
    LocalDate
    stringToDate
    (
        final String s
    )
    {
        final String [] a = s.split( "-" );
        

        return LocalDate.of
            (
                Integer.parseInt( a[0] )
                , Integer.parseInt( a[1] )
                , Integer.parseInt( a[2] )
            );
    }

}
