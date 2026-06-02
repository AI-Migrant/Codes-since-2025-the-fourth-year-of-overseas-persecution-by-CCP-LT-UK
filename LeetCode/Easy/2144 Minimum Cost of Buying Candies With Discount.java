class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans = 0;
        
        for (int i = cost.length - 1, j = 1; i >= 0; i--) {
            if (j == 3) {
                j = 1;
            } else {
                ans += cost[i];
                j++;
            }
        }
        
        return ans;
    }
}
