class Solution {
    int findWays(int n) {
        if (n % 2 == 1) {
            return 0;
        }
        
        final int o = n / 2;
        final ArrayList<HashSet<String>> arrayList = new ArrayList<>(o + 1);
        arrayList.add(new HashSet<>());
        arrayList.add(new HashSet<>());
        arrayList.get(0).add("");
        arrayList.get(1).add("()");
        
        for (int i = 2; i <= o; i++) {
            final HashSet<String> hs = new HashSet<>();
            arrayList.add(hs);
            
            for (int j = i / 2; j < i; j++) {
                for (String s1 : arrayList.get(j)) {
                    for (String s2 : arrayList.get(i - j - 1)) {
                        hs.add("(" + s1 + s2 + ")");
                        hs.add("(" + s2 + s1 + ")");
                        hs.add(s1 + "(" + s2 + ")");
                        hs.add(s2 + "(" + s1 + ")");
                    }
                }
            }
        }
        
        return arrayList.get(o).size();
    }
}