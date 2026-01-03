/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution
{
    
    public
    Node
    flatten
    (
        Node root
    )
    {
        final ArrayList < Node > arrayList = new ArrayList <> ();
        add( arrayList, root );
        root = new Node( 0 );
        Node curr = root;
        
        arrayList.sort
        (
            ( node1, node2 )
            ->
            Integer.compare( node1.data, node2.data )
        );
        
        
        for
        (
            final Node node
            : arrayList
        )
        {
            curr.bottom = node;
            curr = curr.bottom;
        }
        
        
        return root.bottom;
    }
    
    
    
    
    private
    void
    add
    (
        final ArrayList < Node > arrayList
        , final Node root
    )
    {
        arrayList.add( root );
        
        if
        (
            root.bottom != null
        )
        {
            add( arrayList, root.bottom );
            root.bottom = null;
        }
        
        if
        (
            root.next != null
        )
        {
            add( arrayList, root.next );
        }
        
    }
    
}
