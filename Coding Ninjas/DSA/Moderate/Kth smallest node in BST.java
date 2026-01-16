/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/
import java.util.*;





public class Solution
{

    public static
    int
    kthSmallest
    (
        TreeNode root
        , int k
    )
    {
        ArrayList < Integer > list = new ArrayList <> ();
        fill( list, root );


        return list.get( k - 1 );
    }





    static
    void
    fill
    (
        ArrayList < Integer > list
        , TreeNode root
    )
    {
        
        if
        (
            root == null
        )
        {
            return;
        }

        fill( list, root.left );
        list.add( root.data );
        fill( list, root.right );
    }

}
