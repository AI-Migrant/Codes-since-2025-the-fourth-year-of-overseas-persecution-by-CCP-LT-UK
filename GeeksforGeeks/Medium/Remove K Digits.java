class Solution {
    public String removeKdig(String s, int k) {
        final int N = s.length();

        if (N == k) {
            return "0";
        }

        final int K = N - k;
        StringBuilder answer = new StringBuilder(K);
        final char[] arr = s.toCharArray();
        answer.append(arr[0]);


        for (int i = 1; i < N; i++) {

            if (arr[i] < answer.charAt(0) && answer.length() <= k) {
                k -= answer.length();
                answer = new StringBuilder(K);
                answer.append(arr[i]);

                continue;
            }


            while (!answer.isEmpty() &&
                    k >= 1 &&
                    answer.charAt(answer.length() - 1) > arr[i]) {
                answer.deleteCharAt(answer.length() - 1);
                k--;
            }


            answer.append(arr[i]);
        }


        answer.setLength(K);
        int i = 0;


        while (i < K && answer.charAt(i) == '0') {
            i++;
        }
        

        if (i == K) {
            return "0";
        } else {
            return answer.substring(i);
        }

    }
}
