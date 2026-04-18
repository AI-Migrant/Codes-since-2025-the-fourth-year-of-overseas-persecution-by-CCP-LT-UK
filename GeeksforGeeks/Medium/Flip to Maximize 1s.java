class Solution {
    int maxOnes(int[] arr) {
        int c = 0, d = 0, e = 0;
        
        for (final int num : arr) {
            if (num == 0) {
                d = Math.max(d, ++c);
            } else {
                c = Math.max(0, c - 1);
                e++;
            }
        }
        
        return d + e;
    }
}