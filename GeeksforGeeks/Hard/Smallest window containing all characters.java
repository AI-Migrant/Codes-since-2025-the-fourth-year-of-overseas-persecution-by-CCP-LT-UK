class Solution {
    public static String minWindow(String s, String p) {
        final HashMap<Character, Integer> hashMap = new HashMap<>();
        final int n = s.length();
        int k = p.length();
        int o = Integer.MAX_VALUE;
        int u = 0;
        int v = 1;
        char d = s.charAt(0);

        for (final char c : p.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0, j = 0; i < n; i++) {
            final char c = s.charAt(i);
           
            if (hashMap.containsKey(c)) {
                if (hashMap.get(c) > 0) {
                    k--;
                }
                
                hashMap.put(c, hashMap.get(c) - 1);
            }

            while (j < i && (!hashMap.containsKey(d) || hashMap.get(d) < 0)) {
                if (hashMap.containsKey(d)) {
                    hashMap.put(d, hashMap.get(d) + 1);
                }
                
                j++;
                d = s.charAt(j);
            }

            if (k == 0 && i - j < o) {
                o = i - j;
                u = i;
                v = j;
            }
        }

        return s.substring(v, u + 1);
    }
}