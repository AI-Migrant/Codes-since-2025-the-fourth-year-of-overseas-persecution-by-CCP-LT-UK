class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        final int n = words.length;

        for (int i = 0; i <= n / 2; i++) {
            if (target.equals(words[(startIndex + i) % n]) || target.equals(words[(startIndex - i + n) % n])) {
                return i;
            }
        }

        return -1;
    }
}
