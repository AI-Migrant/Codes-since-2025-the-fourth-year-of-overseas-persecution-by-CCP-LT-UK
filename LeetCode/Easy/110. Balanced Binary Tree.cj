/**
 * Definition for a binary tree node.
 * public class BinaryTreeNode {
 *     public var val: Int64
 *     public var left: ?BinaryTreeNode
 *     public var right: ?BinaryTreeNode
 *     public init() {
 *         val = 0
 *         left = None
 *         right = None
 *     }
 *     public init(val: Int64) {
 *         this()
 *         this.val = val
 *     }
 * }
 */

class Solution {
    func isBalanced(root: ?BinaryTreeNode): Bool {
        solve(root) != -1
    }


    func solve(root: ?BinaryTreeNode): Int64 {
        match (root) {
            case Some(node) =>
                let left = solve(node.left)
                let right = solve(node.right)

                if (left == -1 || right == -1 || abs(left - right) >= 2) {
                    -1
                } else {
                    max(left, right) + 1
                }

            case None => 0
        }
    }
}