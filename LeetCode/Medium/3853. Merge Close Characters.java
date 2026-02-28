class Solution {
    public String mergeCharacters(String s, int k) {
        final int n = s.length();
        final StringBuilder answer = new StringBuilder(n);
        final HashMap<Character, Integer> hashMap = new HashMap<>();
        int i = 0;
        
        for (final char c : s.toCharArray()) {
            if (!hashMap.containsKey(c) || hashMap.get(c) + k < i) {
                answer.append(c);
                hashMap.put(c, i);
                i++;
            }
        }

        return answer.toString();
    }
}