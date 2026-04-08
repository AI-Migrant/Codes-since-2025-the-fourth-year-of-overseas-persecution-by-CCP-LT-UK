class Solution {
    void segregate0and1(int[] arr) {
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = arr[j];
                arr[j++] = 0;
            }
        }
    }
}