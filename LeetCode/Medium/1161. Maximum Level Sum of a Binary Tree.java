/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution
{
    
    public
    int
    maxLevelSum
    (
        TreeNode root
    )
    {
        int answer = 1;
        int max = root.val;
        final ArrayDeque < TreeNode > arrayDeque = new ArrayDeque <> ();
        arrayDeque.offer( root );
        
        
        for
        (
            int i = 1
            ; !arrayDeque.isEmpty()
            ; i ++
        )
        {
            int sum = 0;
            
            
            for
            (
                int j = arrayDeque.size()
                ; j > 0
                ; j --
            )
            {
                root = arrayDeque.pollFirst();
                sum += root.val;
                
                if
                (
                    root.left != null
                )
                {
                   arrayDeque.offerLast( root.left );
                }
                
                if
                (
                    root.right != null
                )
                {
                    arrayDeque.offerLast( root.right );
                }
                
            }
            
            
            if
            (
                sum > max
            )
            {
                max = sum;
                answer = i;
            }
            
        }
        
        
        return answer;
    }
    
}
