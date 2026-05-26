class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> hs1 = new HashSet<Character>();
        HashSet<Character> hs2 = new HashSet<Character>();

        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hs1.add(c);
            } else {
                hs2.add(Character.toLowerCase(c));
            }
        }

        hs1.retainAll(hs2);

        return hs1.size();
    }
}