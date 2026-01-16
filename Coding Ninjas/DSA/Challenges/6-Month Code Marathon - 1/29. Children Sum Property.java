/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node left;
     public Node right;

     Node()
     {
         this.data = 0;
         this.left = null;
         this.right = null;
     }

     Node(int data)
     {
         this.data = data;
         this.left = null;
         this.right = null;
     }

     Node(int data, Node left, Node right)
     {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 }

 *****************************************************************/
public class Solution
{

    public static
    boolean
    isParentSum
    (
        Node root
    )
    {

        if
        (
            root == null
        )
        {
            return true;
        }
        else if
        (
            root.left == null
        )
        {

            if
            (
                root.right == null
            )
            {
                return true;
            }
            else
            {
                return
                isParentSum( root.right )
                && root.data == root.right.data;
            }

        }
        else
        {

            if
            (
                root.right == null
            )
            {
                return
                isParentSum( root.left )
                && root.data ==  root.left.data;
            }
            else
            {
                return
                isParentSum( root.left )
                && isParentSum( root.right )
                && root.data == root.left.data + root.right.data;
            }

        }

    }

}
