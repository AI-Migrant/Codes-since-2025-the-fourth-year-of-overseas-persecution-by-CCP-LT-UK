class Solution {
    public boolean checkStrings(String s1, String s2) {
        final HashMap<Character, Integer> hashMap11 = new HashMap<>();
        final HashMap<Character, Integer> hashMap12 = new HashMap<>();
        final HashMap<Character, Integer> hashMap21 = new HashMap<>();
        final HashMap<Character, Integer> hashMap22 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                hashMap11.put(s1.charAt(i), hashMap11.getOrDefault(s1.charAt(i), 0) + 1);
                hashMap21.put(s2.charAt(i), hashMap21.getOrDefault(s2.charAt(i), 0) + 1);
            } else {
                hashMap12.put(s1.charAt(i), hashMap12.getOrDefault(s1.charAt(i), 0) + 1);
                hashMap22.put(s2.charAt(i), hashMap22.getOrDefault(s2.charAt(i), 0) + 1);
            }
        }

        return hashMap11.equals(hashMap21) && hashMap12.equals(hashMap22);
    }
}