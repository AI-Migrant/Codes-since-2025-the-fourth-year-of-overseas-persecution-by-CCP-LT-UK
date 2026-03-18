class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        final int m = grid.length;
        final int n = grid[0].length;
        final int[][] mat = new int[m + 1][n + 1];
        int answer = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1, p = 0; j <= n; j++) {
                p += grid[i - 1][j - 1];
                mat[i][j] = mat[i - 1][j] + p;

                if (mat[i][j] <= k) {
                    answer++;
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}