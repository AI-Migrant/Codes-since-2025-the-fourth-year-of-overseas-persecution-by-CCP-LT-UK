class Solution {
    public int minimumK(int[] nums) {
        int i = 1;
        int j = 10000;

        while (i < j) {
            final int k = (i + j) / 2;
            final int p = k * k;
            int c = 0;

            for (final int num : nums) {
                c += (num + k - 1) / k;
            }

            if (c > p) {
                i = k + 1;
            } else {
                j = k;
            }
        }

        return i;
    }
}