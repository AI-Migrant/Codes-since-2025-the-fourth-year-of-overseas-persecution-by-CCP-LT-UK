class Solution {
    static int[] cache;
    
    
    static {
        cache = new int[1000001];
        Arrays.fill(cache, -1);
    }
    
    
    public int maxSum(int n) {
        if (n == 0) {
            return 0;
        } else if (cache[n] >= 0) {
            return cache[n];
        }
        
        cache[n] = Math.max(n, maxSum(n / 2) + maxSum(n / 3) + maxSum(n / 4));
        
        return cache[n];
    }
}