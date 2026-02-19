class Solution {
    public int countBinarySubstrings(String s) {
        final int n = s.length();
        int answer = 0;

        for (int h = 0, i = 0, j = 1; i < n; h = i, i = j, j++) {
            final char c = s.charAt(i);

            while (j < n && s.charAt(j) == c) {
                j++;
            }

            answer += Math.min(i - h, j - i);
        }

        return answer;
    }
}