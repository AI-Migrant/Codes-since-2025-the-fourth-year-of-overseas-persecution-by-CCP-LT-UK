class Solution {
    public int findKRotation(int arr[]) {
        int i = 0;
        int j = arr.length;
        
        while (i < j) {
            final int k = (i + j) / 2;
            
            if (arr[k] >= arr[0]) {
                i = k + 1;
            } else {
                j = k;
            }
        }
        
        return i % arr.length;
    }
}