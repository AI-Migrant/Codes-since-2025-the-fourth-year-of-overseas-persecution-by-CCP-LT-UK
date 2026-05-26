class Solution {
    int minToggle(int[] arr) {
        int n = arr.length;
        int j = -1;
        int k = 0;
        
        for (int i = 0; i < n; i++) {
            if (j < 0) {
                if (arr[i] > 0) {
                    j = i;
                }
            } else {
                if (arr[i] == 0) {
                    k++;
                }
            }
        }
        
        if (j < 0) {
            return 0;
        }
        
        int answer = k;
        
        while (j < n) {
            if (arr[j++] > 0) {
                k++;
            } else {
                k--;
                answer = Math.min(answer, k);
            }
        }
        
        return answer;
    }
}