/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 };

 *****************************************************************/
import java.util.*;




public class Solution
{

    public static
    Node
    kReverse
    (
        Node head
        , int k
    )
    {
        final ArrayList < Node > arrayList = new ArrayList <> ();
       

        while
        (
            head != null
        )
        {
            arrayList.add( head );

            head = head.next;
        }


        final int n = arrayList.size();


        for
        (
            int i = 0
            ; i + k <= n
            ; i += k
        )
        {
           
           
            for
            (
                int p = i
                    , q = i + k - 1
                ; p < q
                ; p ++, q --
            )
            {
                final Node temp = arrayList.get( p );
                arrayList.set( p, arrayList.get( q ) );
                arrayList.set( q, temp );
            }


        }


        for
        (
            int i = 1
            ; i < n
            ; i ++
        )
        {
            arrayList.get( i - 1 ).next = arrayList.get( i );
        }


        arrayList.get( n - 1 ).next = null;


        return arrayList.get( 0 );
    }

}