class Solution {
    public int maxProductPath(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        final long[] maxes = new long[n];
        final long[] mins = new long[n];

        maxes[0] = mins[0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            maxes[i] = mins[i] = mins[i - 1] * grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            maxes[0] = mins[0] *= grid[i][0];

            for (int j = 1; j < n; j++) {
                if (grid[i][j] < 0) {
                    final long min = Math.max(maxes[j], maxes[j - 1]) * grid[i][j];
                    maxes[j] = Math.min(mins[j], mins[j - 1]) * grid[i][j];
                    mins[j] = min;
                } else {
                    maxes[j] = Math.max(maxes[j], maxes[j - 1]) * grid[i][j];
                    mins[j] = Math.min(mins[j], mins[j - 1]) * grid[i][j];
                }
            }
        }

        if (maxes[n - 1] < 0) {
            return -1;
        } else {
            return (int) (maxes[n - 1] % 1000000007);
        }
    }
}
