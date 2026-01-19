class Solution {

    public int maxSideLength(int[][] mat, int threshold) {
        final int m = mat.length;
        final int n = mat[0].length;
        final int[][] grid = new int[m + 1][n + 1];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i + 1][j + 1] = grid[i + 1][j] + grid[i][j + 1] -
                        grid[i][j] + mat[i][j];
            }
        }


        for (int answer = Math.min(m, n); answer >= 1; answer--) {


            for (int i = answer; i <= m; i++) {


                for (int j = answer; j <= n; j++) {

                    if (grid[i][j] - grid[i - answer][j] - grid[i][j - answer] +
                            grid[i - answer][j - answer] <= threshold) {
                        return answer;
                    }

                }


            }


        }


        return 0;
    }

}
