class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        final StringBuilder answer = new StringBuilder(i + j + 3);
        int c = 0;
        
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                if (a.charAt(i) == '1') {
                    c++;
                }

                i--;
            }

            if (j >= 0) {
                if (b.charAt(j) == '1') {
                    c++;
                }

                j--;
            }

            answer.append(c % 2);
            c /= 2;
        }

        if (c == 1) {
            answer.append(1);
        }

        return answer.reverse().toString();
    }
}