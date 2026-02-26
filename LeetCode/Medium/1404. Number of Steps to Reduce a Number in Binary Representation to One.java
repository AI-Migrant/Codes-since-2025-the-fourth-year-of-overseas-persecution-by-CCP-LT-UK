class Solution {
    public int numSteps(String s) {
        int answer = s.length() - s.lastIndexOf('1') - 1;

        if (answer == s.length() - 1) {
            return answer;
        }

        for (int i = s.length() - answer - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                answer += 2;
            } else {
                answer++;
            }
        }

        return answer + 1;
    }
}