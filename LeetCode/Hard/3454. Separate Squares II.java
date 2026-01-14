class Solution
{

    public
    double
    separateSquares
    (
        int [][] squares
    )
    {
        final HashMap < Integer, HashMap < Integer, Integer > > hashMap
            = new HashMap <> ();

        hashMap.put( 0, new HashMap <> () );


        for
        (
            final int [] square
            : squares
        )
        {
            final int l = square[2];
            final int x1 = square[0];
            final int x2 = x1 + l;
            final int y1 = square[1];
            final int y2 = y1 + l;

            if
            (
                hashMap.containsKey( y1 )
            )
            {
                final HashMap < Integer, Integer > subHashMap
                    = hashMap.get( y1 );

                subHashMap.put( x1, subHashMap.getOrDefault( x1, 0 ) + 1 );
                subHashMap.put( x2, subHashMap.getOrDefault( x2, 0 ) -1 );
            }
            else
            {
                final HashMap < Integer, Integer > subHashMap
                    = new HashMap <> ();

                subHashMap.put( x1, 1 );
                subHashMap.put( x2, -1 );
                hashMap.put( y1, subHashMap );
            }

            if
            (
                hashMap.containsKey( y2 )
            )
            {
                final HashMap < Integer, Integer > subHashMap
                    = hashMap.get( y2 );

                subHashMap.put( x1, subHashMap.getOrDefault( x1, 0 ) - 1  );
                subHashMap.put( x2, subHashMap.getOrDefault( x2, 0 ) + 1 );
            }
            else
            {
                final HashMap < Integer, Integer > subHashMap
                    = new HashMap <> ();

                subHashMap.put( x1, -1 );
                subHashMap.put( x2, 1 );
                hashMap.put( y2, subHashMap );
            }

        }


        final ArrayList < Integer > keyArrayList = new ArrayList <> ( hashMap.keySet() );
        keyArrayList.sort( Comparator.naturalOrder() );
        final TreeMap < Integer, Integer > treeMap = new TreeMap <> ();
        final long [] areas = new long [ keyArrayList.size() ];
        int i = 0;
        long w = 0;
        int y = 0;
        long area = 0L;


        for
        (
            final int hashMapKey
            : keyArrayList
        )
        {
            area += w * ( hashMapKey - y );
            areas[i] = area;
            y = hashMapKey;
            i ++;


            for
            (
                final Map.Entry < Integer, Integer > entry
                : hashMap.get( hashMapKey ).entrySet()
            )
            {
                final Integer subHashMapKey = entry.getKey();

                treeMap.put
                (
                    subHashMapKey
                    , treeMap.getOrDefault( subHashMapKey, 0 )
                        + entry.getValue()
                );

                if
                (
                    treeMap.get( subHashMapKey ).equals( 0 )
                )
                {
                    treeMap.remove( subHashMapKey );
                }


            }


            w = 0L;
            int s = 0;
            int x = 0;


            for
            (
                final Map.Entry < Integer, Integer > entry
                : treeMap.entrySet()
            )
            {

                if
                (
                    s == 0
                )
                {
                    x = entry.getKey();
                    s += entry.getValue();
                }
                else if
                (
                    s == -entry.getValue()
                )
                {
                    w += entry.getKey() - x;
                    s = 0;
                }
                else
                {
                    s += entry.getValue();
                }

            }


        }


        final double target = areas[ areas.length - 1] / 2.0;
        i = 0;
        int j = areas.length - 1;


        while
        (
            i < j
        )
        {
            final int k = ( i + j ) / 2;

            if
            (
                areas[k] >= target
            )
            {
                j = k;
            }
            else
            {
                i = k + 1;
            }

        }

        if
        (
            areas[i] == target
        )
        {
            return keyArrayList.get( i );
        }
        else
        {
            return keyArrayList.get( i - 1 )
                +
                (
                    ( target - areas[i - 1] )
                    * ( keyArrayList.get( i ) - keyArrayList.get( i - 1 ) )
                    / ( areas[i] - areas[i - 1] )
                );
        }
        
    }

}
