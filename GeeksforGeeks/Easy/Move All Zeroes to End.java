class Solution {
    void pushZerosToEnd(int[] arr) {
        int j = 0;
        
        for (final int num : arr) {
            if (num != 0) {
                arr[j++] = num;
            }
        }
        
        while (j < arr.length) {
            arr[j++] = 0;
        }
    }
}