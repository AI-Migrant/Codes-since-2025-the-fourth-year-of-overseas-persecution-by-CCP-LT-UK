class Solution {
    public int reverseBits(int n) {
        final StringBuilder s = new StringBuilder(Integer.toBinaryString(n));
        s.deleteCharAt(s.length() - 1);
        
        return Integer.parseInt(s.reverse().toString() + "0".repeat(31 - s.length()), 2);
    }
}