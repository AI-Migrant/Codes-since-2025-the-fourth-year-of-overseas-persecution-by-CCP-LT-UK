import java.util.*;





public class Solution
{
    public static
    void
    createSentences
    (
        ArrayList < ArrayList < String > > arr
        , ArrayList < ArrayList < String > > ans
    )
    {
        solve( arr, ans, new ArrayList <> () );
    }





    static
    void
    solve
    (
        ArrayList < ArrayList < String > > arr
        , ArrayList < ArrayList < String > > ans
        , ArrayList < String > s
    )
    {

        if
        (
            s.size() == arr.size()
        )
        {
            ans.add( new ArrayList <> ( s ) );


            return;
        }


        for
        (
            String w
            : arr.get( s.size() )
        )
        {
            s.add( w );
            solve( arr, ans, s );
            s.remove( s.size() - 1 );
        }
        
        
    }

}
