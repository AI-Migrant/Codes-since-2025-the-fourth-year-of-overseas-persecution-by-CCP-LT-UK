class Solution {
    public int maxProfit(int[] prices) {
        int buy = 10001;
        int answer = 0;
        
        for (final int price : prices) {
            if (price <= buy) {
                buy = price;
            } else {
                answer = Math.max(answer, price - buy);
            }
        }
        
        return answer;
    }
}