class Solution {
    public int minCost(int[] heights, int[] cost) {
        final IntSummaryStatistics stats = Arrays.stream(heights).summaryStatistics();
        final int n = (int) stats.getCount();
        int i = stats.getMin();
        int j = stats.getMax();
        int pSum = 0;
        int qSum = 0;
        
        while(i < j) {
            final int p = (i + j) / 2;
            final int q = p + 1;
            pSum = 0;
            qSum = 0;
            
            for (int k = 0; k < n; k++) {
                pSum += cost[k] * Math.abs(p - heights[k]);
                qSum += cost[k] * Math.abs(q - heights[k]);
            }
            
            if (pSum < qSum) {
                j = p;
            } else if (pSum > qSum) {
                i = q;
            } else {
                return pSum;
            }
        }
        
        return Math.min(pSum, qSum);
    }
}