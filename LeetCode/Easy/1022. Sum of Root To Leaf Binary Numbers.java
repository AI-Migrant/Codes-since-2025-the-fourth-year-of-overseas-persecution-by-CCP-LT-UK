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
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return solve(root, 0);
    }


    private int solve(final TreeNode root, int val) {
        if (root == null) {
            return 0;
        }

        val = (val << 1) + root.val;
        final int left = solve(root.left, val);
        final int right = solve(root.right, val);

        return Math.max(val, left + right);
    }
}