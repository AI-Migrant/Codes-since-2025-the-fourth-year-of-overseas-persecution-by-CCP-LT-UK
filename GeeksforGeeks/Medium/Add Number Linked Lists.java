/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/
class Solution
{
    
    public
    Node
    addTwoLists
    (
        Node head1
        , Node head2
    )
    {
        head1 = reverse( null, head1 );
        head2 = reverse( null, head2 );
        Node answer = new Node( 0 );
        Node curr = answer;
        
        
        while
        (
            head1 != null
            || head2 != null
        )
        {
            
            if
            (
                head1 != null
            )
            {
                curr.data += head1.data;
                head1 = head1.next;
            }
            
            if
            (
                head2 != null
            )
            {
                curr.data += head2.data;
                head2 = head2.next;
            }
            
            curr.next = new Node( curr.data / 10 );
            curr.data %= 10;
            
            curr = curr.next;
        }
        
        
        answer = reverse( null, answer );
        
        
        while
        (
            answer.next != null
            && answer.data == 0
        )
        {
            answer = answer.next;
        }
        
        
        return answer;
    }
    
    
    
    
    private
    Node
    reverse
    (
        final Node prev
        , final Node head
    )
    {
        
        if
        (
            head.next == null
        )
        {
            head.next = prev;
            
            
            return head;
        }
        else
        {
            final Node next = head.next;
            head.next = prev;
            
            
            return reverse( head, next );
        }
        
    }
    
}
