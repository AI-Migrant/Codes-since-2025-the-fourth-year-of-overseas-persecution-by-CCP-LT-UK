import java.util.*;





public class CircularQueue
{
    ArrayDeque < Integer > q;
    int maxSize;




    // Initialize your data structure.
    public
    CircularQueue
    (
        int n
    )
    {
        this.q = new ArrayDeque();
        this.maxSize = n;
    }





    /*
       Enqueues 'X' into the queue. Returns true if it gets pushed into the stack,
       and false otherwise.
    */
    public
    boolean
    enqueue
    (
        int value
    )
    {
        
        if
        (
            q.size() == maxSize
        )
        {
            return false;
        }

        q.offerLast( value );


        return true;
    }





    /*
      Dequeues top element from queue. Returns -1 if the stack is empty, otherwise
      returns the popped element.
    */
    public
    int
    dequeue
    ()
    {
        
        if
        (
            q.isEmpty()
        )
        {
            return -1;
        }
        else
        {
            return q.pollFirst();
        }

    }

}
