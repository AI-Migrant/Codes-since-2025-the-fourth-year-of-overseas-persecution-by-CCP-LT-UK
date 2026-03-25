class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        ArrayList<Integer> answer = new ArrayList<>();
        final int[] array = new int[V];
        final ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>(V);
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            arrayLists.add(new ArrayList<>());
        }
        
        for (final int[] edge : edges) {
            arrayLists.get(edge[0]).add(edge[1]);
            arrayLists.get(edge[1]).add(edge[0]);
            array[edge[0]]++;
            array[edge[1]]++;
        }
        
        for (int i = 0; i < V; i++) {
            if (array[i] == 1) {
                answer.add(i);
                array[i]--;
            }
        }
        
        int count = answer.size();
        
        while (count < V) {
            final ArrayList<Integer> arrayList = new ArrayList<>();
            
            for (final int i : answer) {
                for (final int j : arrayLists.get(i)) {
                    if (array[j] > 1) {
                        array[j]--;
                        
                        if (array[j] == 1) {
                            arrayList.add(j);
                        }
                    }
                }
            }
            
            answer = arrayList;
            count += answer.size();
        }
        
        return answer;
    }
}