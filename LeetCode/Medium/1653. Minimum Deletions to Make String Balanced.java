class Solution {
    public int minimumDeletions(String s) {
        int bs = 0;
        int answer = 0;

        for (final char c : s.toCharArray()) {
            if (c == 'a') {
                if (bs != 0) {
                answer++;
                bs--;
                }
            } else {
                bs++;
            }
        }

        return answer;
    }
}