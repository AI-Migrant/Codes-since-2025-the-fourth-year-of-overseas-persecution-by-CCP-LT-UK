class Solution {
    int maxSum(int[] arr) {
        final int n = arr.length;
        int sum = 0;
        int mSum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            mSum += arr[i] * i;
        }
        
        int answer = mSum;
        
        for (int i = n - 1; i >= 1; i--) {
            mSum -= (arr[i] * n) - sum;
            answer = Math.max(answer, mSum);
        }
        
        return answer;
    }
}