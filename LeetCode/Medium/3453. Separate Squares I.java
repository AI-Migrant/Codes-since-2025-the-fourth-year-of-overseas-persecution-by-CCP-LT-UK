import java.util.AbstractMap.*;




class Solution
{

    public
    double
    separateSquares
    (
        int [][] squares
    )
    {
        Arrays.sort( squares, ( s1, s2 ) -> Integer.compare( s1[1], s2[1] ) );
        double w = 0.0;
        double total = 0.0;

        PriorityQueue < SimpleImmutableEntry < Integer, Integer > >
            priorityQueue = new PriorityQueue <>
            (
                ( e1, e2 ) -> e1.getKey().compareTo( e2.getKey() )
            );
        
        ArrayList < SimpleImmutableEntry < Integer, Double > > arrayList
            = new ArrayList <> ();

        arrayList.add( new SimpleImmutableEntry <> ( 0, 0.0 ) );
        

        for
        (
            int [] square
            : squares
        )
        {


            while
            (
                !priorityQueue.isEmpty()
                && priorityQueue.peek().getKey() <= square[1]
            )
            {
                int key = priorityQueue.peek().getKey();


                if
                (
                    key != arrayList.getLast().getKey()
                )
                {
                    total += w * ( key - arrayList.getLast().getKey() );
                    arrayList.add( new SimpleImmutableEntry <> ( key, total ) );
                }

                w -= priorityQueue.poll().getValue();
            }


            if
            (
                square[1] != arrayList.getLast().getKey()
            )
            {
                total += w * ( square[1] - arrayList.getLast().getKey() );
                
                arrayList.add(
                    new SimpleImmutableEntry <> ( square[1], total )
                );
            }

            priorityQueue.offer( new SimpleImmutableEntry <>
                (
                    square[1] + square[2]
                    , square[2]
                )
            );
            
            w += square[2];
        }


        while
        (
            !priorityQueue.isEmpty()
        )
        {
            int key = priorityQueue.peek().getKey();

            if
            (
                key != arrayList.getLast().getKey()
            )
            {
                total += w * ( key - arrayList.getLast().getKey() );
                arrayList.add( new SimpleImmutableEntry <> ( key, total ) );
            }

            w -= priorityQueue.poll().getValue();
        }


        final double target = total / 2.0;
        
        int i = Collections.binarySearch
            (
                arrayList
                , new SimpleImmutableEntry <> ( 0, target )
                , Comparator.comparing( SimpleImmutableEntry::getValue )
            );

        if
        (
            i >= 0
        )
        {
            
            
            while
            (
                arrayList.get( i ).getValue()
                    .equals( arrayList.get( i - 1 ).getValue() )
            )
            {
                i --;
            }


            return arrayList.get( i ).getKey();
        }
        else
        {
            i = ~i;

            
            return
                arrayList.get( i - 1 ).getKey()
                +
                (
                    ( target - arrayList.get( i - 1 ).getValue() )
                    /
                    (
                        (
                            arrayList.get( i ).getValue()
                            - arrayList.get( i - 1 ).getValue()
                        )
                        /
                        (
                            arrayList.get( i ).getKey()
                            - arrayList.get( i - 1 ).getKey()
                        )
                    )
                );
        }

    }

}
