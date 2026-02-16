class Solution {
    static boolean canAttend(int[][] arr) {
        final int n = arr.length;
        Arrays.sort(arr, (x, y) -> Integer.compare(x[0], y[0]));
        int[] prev = { 0, Integer.MIN_VALUE };
        
        for (final int[] curr: arr) {
            if (curr[0] < prev[1]) {
                return false;
            }
            
            prev = curr;
        }
        
        return true;
    }
}