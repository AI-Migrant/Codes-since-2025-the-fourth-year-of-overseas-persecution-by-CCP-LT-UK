class Solution {
    func nextGreatestLetter(letters: Array<Rune>, target: Rune): Rune {
        for (letter in letters) {
            if (letter > target) {
                return letter
            }
        }

        letters[0];
    }
}