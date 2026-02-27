class Solution {
    public int countSquare(int[][] mat, int x) {
        final int n = mat.length;
        final int m = mat[0].length;
        final int[][] grid = new int[n + 1][m + 1];
        final int[] prev = new int[m + 1];
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prev[j] = prev[j - 1] + mat[i - 1][j - 1];
                grid[i][j] = prev[j] + grid[i - 1][j];
                
                for (int p = i - 1, q = j - 1; p >= 0 && q >= 0; p--, q--) {
                    if (grid[i][j] - grid[p][j] - grid[i][q] + grid[p][q] == x) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}
