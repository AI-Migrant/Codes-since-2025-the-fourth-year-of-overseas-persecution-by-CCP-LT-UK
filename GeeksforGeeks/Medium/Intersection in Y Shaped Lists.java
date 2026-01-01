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
    intersectPoint
    (
        Node head1
        , Node head2
    )
    {
        Node node1 = head1;
        Node node2 = head2;
        
        
        while
        (
            node1 != null
            && node2 != null
        )
        {
            node1 = node1.next;
            node2 = node2.next;
        }
        
        if
        (
            node1 == null
        )
        {
            node1 = head2;
        }
        else
        {
            node2 = head1;
        }
        
        
        while
        (
            node1 != null
            && node2 != null
        )
        {
            node1 = node1.next;
            node2 = node2.next;
        }
        
        
        if
        (
            node1 == null
        )
        {
            node1 = head2;
        } 
        else
        {
            node2 = head1;
        }
        
        
        while
        (
            node1 != node2
        )
        {
            node1 = node1.next;
            node2 = node2.next;
        }
        
        
        return node1;
    }
    
}
