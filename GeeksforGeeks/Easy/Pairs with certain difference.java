class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        Arrays.sort(arr);
        int ans = 0;
        
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] - arr[i - 1] < k) {
                ans += arr[i] + arr[--i];
            }
        }
        
        return ans;
    }
}
