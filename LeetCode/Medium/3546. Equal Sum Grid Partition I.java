class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        final long[] arr1 = new long[m];
        final long[] arr2 = new long[n];
        long sum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr1[i] += grid[i][j];
                arr2[j] += grid[i][j];
            }

            sum += arr1[i];
        }

        if (sum % 2 == 1) {
            return false;
        }

        final long target = sum / 2;
        sum = 0;
        
        for (final long i : arr1) {
            sum += i;

            if (sum == target) {
                return true;
            }
        }

        sum = 0;

        for (final long i : arr2) {
            sum += i;

            if (sum == target) {
                return true;
            }
        }

        return false;
    }
}