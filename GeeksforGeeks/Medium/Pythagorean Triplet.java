class Solution {
    private static ArrayList<Integer> arrayList;
    private static HashSet<Integer> hashSet;
    private static HashMap<Integer, ArrayList<Integer>> hashMap;
    
    
    static {
        arrayList = new ArrayList<>();
        hashSet = new HashSet<>();
        hashMap = new HashMap<>();
        
        for (int i = 2, j = 4; j <= 1000000; i++, j = i * i) {
            arrayList.add(j);
            hashSet.add(j);
        }
        
        final int n = arrayList.size();
        
        for (int i = 0; arrayList.get(i) + arrayList.get(i + 1) <= arrayList.getLast(); i++) {
            final int a = arrayList.get(i);
            
            for (int j = i + 1; j < n; j++) {
                final int b = arrayList.get(j);
                final int c = a + b;
                
                if (hashSet.contains(c)) {
                    if (!hashMap.containsKey(c)) {
                        hashMap.put(c, new ArrayList<>());
                    }
                    
                    hashMap.get(c).add(a);
                }
            }
        }
    }
    
    
    boolean pythagoreanTriplet(int[] arr) {
        final HashSet<Integer> hashSet1 = new HashSet<>();
        
        for (final int num : arr) {
            hashSet1.add(num * num);
        }
        
        for (final int c : hashSet1) {
            if (hashMap.containsKey(c)) {
                for (final int a : hashMap.get(c)) {
                    if (hashSet1.contains(a) && hashSet1.contains(c - a)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}
