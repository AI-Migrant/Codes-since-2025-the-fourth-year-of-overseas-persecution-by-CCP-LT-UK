class Solution {
    public boolean hasAlternatingBits(int n) {
        for (int i = (Integer.highestOneBit(n) >> 1), j = 0; i != 0; i >>= 1, j = 1 - j) {
            if (((i & n) == 0) != (j == 0)) {
                return false;
            }
        }

        return true;
    }
}