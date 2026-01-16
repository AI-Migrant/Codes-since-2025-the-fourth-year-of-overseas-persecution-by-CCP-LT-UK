/************************************************************
 * 
 * Following is the TreeNode class structure
 * class TreeNode < T >
 * {
 *     public: T data;
 *     TreeNode < T > left;
 *     TreeNode<T> right;
 * 
 *     TreeNode
 *     (
 *         T data
 *     )
 *     {
 *         this.data = data;
 *         left = null;
 *         right = null;
 *     }
 *  };
 ************************************************************/
import java.util.*;






public class Solution
{
    public static
    Boolean
    isDeadEnd
    (
        TreeNode < Integer > root
    )
    {
        HashSet < Integer > set = new HashSet <> ();
        set.add( 0 );

        
        return solve( root, set );
    }




    static
    boolean
    solve
    (
        TreeNode < Integer > root
        , HashSet < Integer > set
    )
    {
        
        if
        (
            root == null
        )
        {
            return false;
        }

        set.add( root. data );

        if
        (
            root.left == null
        )
        {

            if
            (
                root.right == null
            )
            {
                return set.contains( root.data + 1 )
                    && set.contains( root.data - 1 );
            }
            else
            {
                return solve( root.right, set );
            }

        }
        else
        {
            return solve( root.left, set )
                || solve( root.right, set );
        }

    }

}
