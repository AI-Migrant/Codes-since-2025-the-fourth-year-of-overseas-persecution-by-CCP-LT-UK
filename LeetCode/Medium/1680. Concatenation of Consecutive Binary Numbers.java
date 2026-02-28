class Solution {
    private final static long MOD = 1_000_000_007;


    public int concatenatedBinary(int n) {
        long answer = 0;

        for (int i = 1; i <= n; i++) {
            answer = ((answer << (32 - Integer.numberOfLeadingZeros(i))) | i) % MOD;
        }

        return (int) answer;
    }
}