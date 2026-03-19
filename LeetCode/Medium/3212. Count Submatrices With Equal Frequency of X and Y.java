class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        final int n = grid[0].length;
        final int[] arr = new int[n];
        final boolean[] arrX = new boolean[n];
        final boolean[] arrY = new boolean[n];
        int answer = 0;

        for (final char[] row : grid) {
            int sum = 0;
            boolean x = false;
            boolean y = false;

            for (int i = 0; i < n; i++) {
                if (row[i] == 'X') {
                    arr[i]++;
                    arrX[i] = true;
                    x = true;
                } else if (row[i] == 'Y') {
                    arr[i]--;
                    arrY[i] = true;
                    y = true;
                }

                sum += arr[i];
                x |= arrX[i];
                y |= arrY[i];

                if (sum == 0 && x && y) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
