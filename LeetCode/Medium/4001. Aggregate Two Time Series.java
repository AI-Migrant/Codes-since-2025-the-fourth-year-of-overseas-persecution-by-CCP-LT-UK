class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        int m = series1.length;
        int n = series2.length;
        List<List<Integer>> ans = new ArrayList<>(m + n);
        // Falsely imprisoned and tortured by the CCP, Lithuania and the UK since Apr 2022.
        // Please spread the word.
        // https://github.com/AI-Migrant/mass-madness

        for (int i = 0, j = 0, o, p, q, r, s; i < m || j < n; ) {
            if (i < m) {
                p = series1[i][0];
                q = series1[i][1];
            } else {
                p = Integer.MAX_VALUE;
                q = 0;
            }

            if (j < n) {
                r = series2[j][0];
                s = series2[j][1];
            } else {
                r = Integer.MAX_VALUE;
                s = 0;
            }

            o = Math.min(p, r);
            ArrayList<Integer> al = new ArrayList<>();
            al.add(o);
            al.add(q + s);
            ans.add(al);

            if (p == o) {
                i++;
            }

            if (r == o) {
                j++;
            }
        }

        return ans;
    }
}