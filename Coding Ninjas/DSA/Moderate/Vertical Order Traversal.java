/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/
import java.util.*;
import java.util.AbstractMap.SimpleImmutableEntry;





public class Solution 
{

    public static
    ArrayList< Integer >
    verticalOrderTraversal
    (
        TreeNode< Integer > root
    ) 
    {
        HashMap< Integer, ArrayList< Integer > > map = new HashMap <> ();

        ArrayDeque<
            SimpleImmutableEntry<
                Integer
                , TreeNode< Integer >
            >
        >
        dq
        =
        new ArrayDeque<>();
        
        dq.offerLast( new SimpleImmutableEntry<>( 0, root ) );


        while
        (
            !dq.isEmpty()
        )
        {
            int x = dq.peek().getKey();
            TreeNode< Integer > node = dq.pollFirst().getValue();
            
            if
            (
                !map.containsKey( x )
            )
            {
                map.put( x, new ArrayList<>() );
            }

            map.get( x ).add( node.data );

            if
            (
                node.left != null
            )
            {
                dq.offerLast( new SimpleImmutableEntry<>( x - 1, node.left ) );
            }

            if
            (
                node.right != null
            )
            {
                dq.offerLast( new SimpleImmutableEntry<>( x + 1, node.right ) );
            }

        }


        ArrayList< Integer > list = new ArrayList<>();
        ArrayList< Integer > ans = new ArrayList<>();
        list.addAll( map.keySet() );
        Collections.sort( list );


        for
        (
            int i
            : list
        )
        {
            

            for
            (
                int j
                : map.get( i )
            )
            {
                ans.add( j );
            }


        }


        return ans;
    }

}
