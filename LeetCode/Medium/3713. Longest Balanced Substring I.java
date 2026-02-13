class Solution {
    public int longestBalanced(String s) {
        final char[] a = s.toCharArray();
        final int[] c = new int[26];
        final int n = a.length;
        int answer = 1;

        for (int i = 0; i < n - answer; i++) {
            Arrays.fill(c, 0);
            final int o = i + answer;
            int d = 0;
            int m = 1;

            for (int j = i; j < o; j++) {
                final int k = a[j] - 'a';

                if (c[k] == 0) {
                    d++;
                }

                c[k]++;
                m = Math.max(m, c[k]);
            }

            for (int j = o, p = answer + 1; j < n; j++, p++) {
                final int k = a[j] - 'a';

                if (c[k] == 0) {
                    d++;
                }

                c[k]++;
                m = Math.max(m, c[k]);

                if (d * m == p) {
                    answer = p;
                }
            }
        }

        return answer;
    }
}