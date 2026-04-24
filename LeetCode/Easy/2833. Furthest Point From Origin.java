class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int p = 0;
        int q = 0;

        for (final char move : moves.toCharArray()) {
            if (move == 'L') {
                p--;
            } else if (move == 'R') {
                p++;
            } else {
                q++;
            }
        }

        return Math.abs(p) + q;
    }
}