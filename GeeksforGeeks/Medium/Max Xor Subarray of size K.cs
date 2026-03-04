class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int xor = 0;
        
        foreach (int num in arr[..k]) {
            xor ^= num;
        }
        
        int answer = xor;
        
        for (int i = k, j = 0; i < arr.Length; i++, j++) {
            xor ^= arr[i] ^ arr[j];
            answer = Math.Max(answer, xor);
        }
        
        return answer;
    }
}