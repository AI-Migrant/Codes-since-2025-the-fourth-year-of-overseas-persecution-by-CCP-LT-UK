class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        final int m = mat.length;
        final int n = mat[0].length;
        final int o = (k / n + 1) * n;

        for (final int[] r : mat) {

            for (int j = 0; j < n; j++) {
                if (r[(j - k + o) % n] != r[j]) {
                    return false;
                }
            }

            k *= -1;
        }

        return true;
    }
}