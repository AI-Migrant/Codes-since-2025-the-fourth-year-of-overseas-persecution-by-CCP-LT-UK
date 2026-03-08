import java.util.AbstractMap.*;


class Solution {
    private static ArrayList<Integer> arrayList;
    private static HashSet<Integer> hashSet;
    private static HashMap<Integer, SimpleImmutableEntry<Integer, Integer>> hashMap;
    
    
    static {
        arrayList = new ArrayList<>();
        hashSet = new HashSet<>();
        hashMap = new HashMap<>();
        
        for (int i = 2, j = 4; j <= 1000; i++, j = i * i) {
            arrayList.add(j);
            hashSet.add(j);
        }
        
        final int n = arrayList.size();
        
        for (int i = 0; arrayList.get(i) + arrayList.get(i + 1) <= arrayList.getLast(); i++) {
            final int a = arrayList.get(i);
            
            for (int j = i + 1; j < n; j++) {
                final int b = arrayList.get(j);
                
                if (hashSet.contains(a + b)) {
                    hashMap.put(a + b, new SimpleImmutableEntry<>(a, b));
                }
            }
        }
    }
    
    
    boolean pythagoreanTriplet(int[] arr) {
        final HashSet<Integer> hashSet1 = new HashSet<>();
        
        for (final int num : arr) {
            hashSet1.add(num);
        }
        
        for (final int c : arr) {
            if (hashMap.containsKey(c) && hashSet1.contains(hashMap.get(c).getKey()) && hashSet1.contains(hashMap.get(c).getValue())) {
                return true;
            }
        }
        
        return false;
    }
}