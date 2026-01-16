import java.util.*;

/*
    Definition of Node class for reference  
    class Node {
        int value;
        Node prev;
        Node next;
    
        Node(int value) {
            this.value = value;
            prev = next = null;
        }
    }
*/

public class Solution
{

    public static
    Node
    quickSort
    (
        Node head
    )
    {
        return sort( head )[0];
    }




    static
    Node[]
    sort
    (
        Node head
    )
    {
        Node[] ans = new Node[] { head, head };
        
        if
        (
            head == null
            || head.next == null
        )
        {
            return ans;
        }

        Node node1 = new Node( 0 );
        Node node2 = new Node( 0 );
        Node curr = head.next;
        Node curr1 = node1;
        Node curr2 = node2;


        while
        (
            curr != null
        )
        {

            if
            (
                curr.value < head.value
            )
            {

                if
                (
                    curr.next != null
                )
                {
                    curr.next.prev = curr.prev;
                    curr.prev.next = curr.next;
                }

                curr.prev = curr1;
                curr1.next = curr;
                curr1 = curr;
            }
            else
            {
                curr2.next = curr;
                curr.prev = curr2;
                curr2 = curr;
            }

            curr = curr.next;
        }

        curr1.next = null;
        curr2.next = null;
        node1 = node1.next;
        node2 = node2.next;

        if
        (
            node1 != null
        )
        {
            Node[] temp = sort( node1 );
            head.prev = temp[1];
            temp[1].next = head;
            ans[0] = temp[0];
        }

        if
        (
            node2 != null
        )
        {
            Node[] temp = sort( node2 );
            head.next = temp[0];
            temp[0].prev = head;
            ans[1] = temp[1];
        }
        else
        {
            head.next = null;
        }


        return ans; 
    }

}

