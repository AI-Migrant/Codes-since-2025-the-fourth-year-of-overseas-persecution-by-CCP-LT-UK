import java.util.*;





public class BoundedBlockingQueue
{
    int capacity;
    ArrayDeque < Integer > dq;





    BoundedBlockingQueue
    (
        int capacity
    )
    {
        dq = new ArrayDeque <> ();
        this.capacity = capacity;
    }





    void
    Enqueue
    (
        int val
    )
    {   
        
        if
        (
            !dq.isEmpty()
            && dq.peekFirst() < 0
        )
        {
            dq.pollFirst();
            System.out.print( val + " " );
        }
        else
        {
            dq.offerLast( val );
        }

    }





    int
    Dequeue
    ()
    {
        if
        (
            dq.isEmpty()
            || dq.peekFirst() < 0
        )
        {
            dq.offerLast( -1 );


            return -1;
        }
        else
        {
            return dq.pollFirst();
        }
        
    }





    int
    size
    ()
    {
        if
        (
            dq.isEmpty()
            || dq.peekFirst() < 0
        )
        {
            return 0;
        }
        else
        {
            return Math.min( capacity, dq.size() );
        }

    }

}
