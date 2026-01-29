class Solution {
    public String firstNonRepeating(String s) {
        final int n = s.length();
        final TreeMap<Integer, Character> treeMap = new TreeMap<>();
        final HashMap<Character, Integer> hashMap = new HashMap<>();
        final StringBuilder answer = new StringBuilder();
        int repeated = 0;

        for (int i = 0; i < n; i++) {
            final char c = s.charAt(i);

            if (hashMap.containsKey(c)) {
                if (hashMap.get(c) != -1) {
                    treeMap.remove(hashMap.get(c));
                    hashMap.put(c, -1);
                    repeated++;
                }
            } else {
                hashMap.put(c, i);
                treeMap.put(i, c);
            }

            if (repeated == 26) {
                break;
            } else if (!treeMap.isEmpty()) {
                answer.append(treeMap.firstEntry().getValue());
            } else {
                answer.append('#');
            }
        }

        return answer.toString() + "#".repeat(n - answer.length());
    }
}