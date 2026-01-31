class Solution {
    public String reverseByType(String s) {
        final char[] cArray = s.toCharArray();
        final int length = s.length();
        final boolean[] bArray = new boolean[length];
        final StringBuilder answer = new StringBuilder(length);
        final Stack<Character> letterStack = new Stack<>();
        final Stack<Character> specialStack = new Stack<>();

        for (int i = 0; i < length; i++) {
            if (Character.isLowerCase(cArray[i])) {
                letterStack.push(cArray[i]);
                bArray[i] = true;
            } else {
                specialStack.push(cArray[i]);
            }
        }

        for (final boolean b : bArray) {
            if (b) {
                answer.append(letterStack.pop());
            } else {
                answer.append(specialStack.pop());
            }
        }

            return answer.toString();
    }
}