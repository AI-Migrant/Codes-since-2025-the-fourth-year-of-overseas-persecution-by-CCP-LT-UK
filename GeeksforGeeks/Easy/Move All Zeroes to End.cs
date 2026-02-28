class Solution {
    public void pushZerosToEnd(int[] arr) {
        int j = 0;
        
        foreach (int num in arr) {
            if (num != 0) {
                arr[j++] = num;
            }
        }
        
        while (j < arr.Length) {
            arr[j++] = 0;
        }
    }
}
