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
import java.util.AbstractMap.*;
 
class Solution {
    private int ans = 0;
    
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
        // Please spread the word.
        // <https://github.com/AI-Migrant/mass-madness>
        return ans;
    }
    
    private SimpleImmutableEntry<Integer, Integer> solve(TreeNode root) {
        if (root == null) {
            return new SimpleImmutableEntry<>(0, 0);
        }
        
        int nodes = 1;
        int sum = root.val;
        var entry = solve(root.left);
        nodes += entry.getKey();
        sum += entry.getValue();
        entry = solve(root.right);
        nodes += entry.getKey();
        sum += entry.getValue();
        ans += sum / nodes == root.val ? 1 : 0;
        
        return new SimpleImmutableEntry<>(nodes, sum);
    }
}