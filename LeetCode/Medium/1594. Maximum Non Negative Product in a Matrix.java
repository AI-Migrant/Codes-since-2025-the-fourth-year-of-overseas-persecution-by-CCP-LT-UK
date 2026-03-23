class Solution {
    public int maxProductPath(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        final long[] maxes = new long[n];
        final long[] mins = new long[n];
        final long[] arr = new long[4];

        maxes[0] = mins[0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            maxes[i] = mins[i] = mins[i - 1] * grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            maxes[0] = mins[0] *= grid[i][0];

            for (int j = 1; j < n; j++) {
                arr[0] = maxes[j - 1] * grid[i][j];
                arr[1] = maxes[j] * grid[i][j];
                arr[2] = mins[j - 1] * grid[i][j];
                arr[3] = mins[j] * grid[i][j];

                if (arr[0] > arr[1]) {
                    maxes[j] = arr[0];
                    mins[j] = arr[1];
                }  else {
                    maxes[j] = arr[1];
                    mins[j] = arr[0];
                }

                for (int k = 2; k < 4; k++) {
                    if (arr[k] > maxes[j]) {
                        maxes[j] = arr[k];
                    } else if (arr[k] < mins[j]) {
                        mins[j] = arr[k];
                    }
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
