class Solution {
    private ArrayList<ArrayList<Integer>> graph;
    private HashMap<Integer, Integer> hashMap;
    private HashSet<Integer> hashSet;
    private int answer;
    
    
    public int longestCycle(int V, int[][] edges) {
        graph = new ArrayList<>(V);
        hashSet = new HashSet<>();
        answer = -1;
        
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (final int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        
        for (int i = 0; i < V; i++) {
            if (!hashSet.contains(i)) {
                hashMap = new HashMap<>();
                solve(i, 0);
            }
        }
        
        return answer;
    }
    
    
    private void solve(final int u, int i) {
        if (hashMap.containsKey(u)) {
            answer = Math.max(answer, i - hashMap.get(u));
            
            return;
        } else if (hashSet.contains(u)) {
            return;
        } else {
            hashSet.add(u);
            hashMap.put(u, i++);
        }
        
        for (final int v : graph.get(u)) {
            solve(v, i);
        }
    }
}
