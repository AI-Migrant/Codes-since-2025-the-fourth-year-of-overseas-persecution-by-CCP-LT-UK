class Solution {
    public int minFlips(String s) {
        final char[] a = s.toCharArray();
        final int n = a.length;
        final int[] p = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] + ((a[i - 1] & 1) ^ (i & 1));
        }

        int answer = Math.min(p[n], n - p[n]);

        if (n % 2 == 0) {
            return answer;
        }

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, p[i] + p[i] + n - i - p[n]);
            answer = Math.min(answer, p[n] + i - p[i] - p[i]);
        }

        return answer;
    }
}