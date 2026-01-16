import java.util.*;
import java.util.AbstractMap.*;






public class Solution
{

    public static
    List <Integer >
    dijkstra
    (
        int[][] edge
        , int vertices
        , int edges
        , int source
    )
    {
        ArrayList < Integer > ans = new ArrayList <> ();

        ArrayList < ArrayList < SimpleImmutableEntry < Integer, Integer > > >
        list
        =
        new ArrayList <> ();
        
        PriorityQueue < SimpleImmutableEntry < Integer, Integer > > pq =
            new PriorityQueue <> ( new EntryComparator() );

            
        for
        (
            int i = 0
            ; i < vertices
            ; i ++
        )
        {
            ans.add( 0 );
            list.add( new ArrayList <> () );
        }


        ans.set( source, 1 );
        int n = vertices;


        for
        (
            int[] e
            : edge
        )
        {
            list.get( e[0] ).add( new SimpleImmutableEntry <> ( e[1], e[2] ) );
            list.get( e[1] ).add( new SimpleImmutableEntry <> ( e[0], e[2] ) );
        }


        for
        (
            SimpleImmutableEntry < Integer, Integer > entry
            : list.get( source )
        )
        {
            pq.offer
            (
                new SimpleImmutableEntry <> ( entry.getKey(), entry.getValue() )
            );
        }


        while
        (
            n > 1
        )
        {
            SimpleImmutableEntry < Integer, Integer > entry = pq.poll();
            Integer node = entry.getKey();
            Integer distance = entry.getValue();

            if
            (
                ans.get( node ) > 0
            )
            {
                continue;
            }

            ans.set( node, distance );
            n --;


            for
            (
                SimpleImmutableEntry < Integer, Integer > next
                : list.get( node )
            )
            {

                if
                (
                    ans.get( next.getKey() ) > 0
                )
                {
                    continue;
                }

                pq.offer
                (
                    new SimpleImmutableEntry <>
                    (
                        next.getKey()
                        , next.getValue() + distance
                    )
                );
            }


        }


        ans.set( source, 0 );


        return ans;
    }

}







class EntryComparator
implements Comparator < SimpleImmutableEntry < Integer, Integer > >
{

    @Override
    public
    int
    compare
    (
        SimpleImmutableEntry < Integer, Integer > x
        , SimpleImmutableEntry < Integer, Integer > y
    )
    {
        return x.getValue().compareTo( y.getValue() );
    }

}
