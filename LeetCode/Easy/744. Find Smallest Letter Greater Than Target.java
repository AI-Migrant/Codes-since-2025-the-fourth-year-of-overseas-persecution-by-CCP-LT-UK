class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for (final char letter : letters) {
            if (letter > target) {
                return letter;
            }
        }

        return letters[0];
    }
}