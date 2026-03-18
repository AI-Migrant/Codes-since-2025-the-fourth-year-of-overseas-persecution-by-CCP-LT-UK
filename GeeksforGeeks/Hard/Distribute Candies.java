/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private int answer;
    
    
    public int distCandy(Node root) {
        answer = 0;
        solve(root);

        return answer;
    }

    private int solve(Node root) {
        if (root == null) {
            return 0;
        }

        final int left = solve(root.left);
        final int right = solve(root.right);
        final int moves = root.data + left + right - 1;
        answer += Math.abs(moves);

        return moves;
    }
}