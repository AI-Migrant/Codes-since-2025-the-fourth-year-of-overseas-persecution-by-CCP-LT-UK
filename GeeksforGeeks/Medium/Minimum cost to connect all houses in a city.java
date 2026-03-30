class Solution {
    private HashMap<Integer, Integer> hashMap;
    
    
    public int minCost(int[][] houses) {
        final int n = houses.length;
        final int o = n * (n - 1) / 2;
        final ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>(o);
        hashMap = new HashMap<>();
        int count = n - 1;
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            hashMap.put(i, i);
            
            for (int j = i + 1; j < n; j++) {
                final ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                arrayList.add(j);
                arrayList.add(Math.abs(houses[i][0] - houses[j][0]) + Math.abs(houses[i][1] - houses[j][1]));
                arrayLists.add(arrayList);
            }
        }
        
        arrayLists.sort(Comparator.comparingInt(ArrayList::getLast));
        
        for (final ArrayList<Integer> arrayList : arrayLists) {
            final Integer i = find(arrayList.getFirst());
            final Integer j = find(arrayList.get(1));
            
            if (!i.equals(j)) {
                hashMap.put(j, i);
                count--;
                answer += arrayList.getLast();
                
                if (count == 0) {
                    break;
                }
            }
        }
        
        return answer;
    }
    
    
    private Integer find(final Integer i) {
        if (!hashMap.get(i).equals(i)) {
            hashMap.put(i, find(hashMap.get(i)));
        }
        
        return hashMap.get(i);
    }
}