class Solution {
    public int maxOnes(int arr[], int k) {
        int n = arr.length;
        int answer = 0;

        for (int i = 0, j = -1; i < n; i++) {
            if (arr[i] == 0) {
                k--;

                while (k < 0 && j <= i) {
                    j++;

                    if (arr[j] == 0) {
                        k++;
                    }
                }
            }
            
            answer = Math.max(answer, i - j);
        }

        return answer;
    }
}