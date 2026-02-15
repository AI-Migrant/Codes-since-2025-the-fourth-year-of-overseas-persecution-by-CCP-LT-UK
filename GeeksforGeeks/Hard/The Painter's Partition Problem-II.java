class Solution {
    public int minTime(int[] arr, int k) {
        final var stats = Arrays.stream(arr).summaryStatistics();
        final int n = arr.length;
        int i = stats.getMax();
        int j = stats.getSum();
        
        while (i < j) {
            final int m = (i + j) / 2;
            int p = 0;
            int q = 1;
            
            for (int a : arr) {
                p += a;
                
                if (p > m) {
                    q++;
                    
                    if (q > k) {
                        break;
                    }
                    
                    p = a;
                }
            }
            
            if (q > k) {
                i = m + 1;
            } else {
                j = m;
            }
        }
        
        return i;
    }
}