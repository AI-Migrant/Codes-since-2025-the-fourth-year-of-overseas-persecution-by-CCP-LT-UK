class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n - Integer.valueOf(new StringBuilder(Integer.toString(n)).reverse().toString()));
    }
}