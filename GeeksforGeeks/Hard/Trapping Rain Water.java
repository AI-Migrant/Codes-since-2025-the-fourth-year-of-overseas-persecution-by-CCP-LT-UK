class Solution {
    public int maxWater(int[] arr) {
        final int n = arr.length;
        final int[] pre = new int[n + 1];
        pre[1] = arr[0];
        
        if (n <= 2) {
            return 0;
        }
        
        int answer = 0;
        int i = 0;
        int j = 1;
        int k = 1;
        
        while (j < n) {
            pre[j + 1] = pre[j] + arr[j];
            
            if (arr[i] <= arr[j]) {
                answer += ((j - i - 1) * arr[i]) - pre[j] + pre[i + 1];
                i = j;
                k = j + 1;
                j++;
                
                continue;
            } else if (arr[j] > arr[k]) {
                k = j;
            }
            
            j++;
            
            if (j == n) {
                answer += ((k - i - 1) * arr[k]) - pre[k] + pre[i + 1];
                i = k;
                j = i + 1;
                k = j;
            }
        }
        
        return answer;
    }
}