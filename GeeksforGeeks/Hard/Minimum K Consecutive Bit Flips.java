class Solution {
    public int kBitFlips(int[] arr, int k) {
        final int n = arr.length;
        final int[] a = new int[n + 1];
        int answer = 0;

        for (int i = 0, j = 0; i < n; i++, j += a[i]) {
            if ((arr[i] + j) % 2 == 0) {
                if (i + k > n) {
                    return -1;
                }

                j++;
                a[i + k]--;
                answer++;
            }
        }

        return answer;
    }
}