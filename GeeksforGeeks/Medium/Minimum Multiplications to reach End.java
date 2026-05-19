class Solution {
    public int minSteps(int[] arr, int start, int end) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        HashSet<Integer> hs = new HashSet<>();
        boolean[] done = new boolean[1000];
        int steps = 0;
        dq.offer(start);
        
        for (int i : arr) {
            hs.add(i);
        }
        
        while (!dq.isEmpty()) {
            for (int i = dq.size(); i > 0; i--) {
                int p = dq.poll();
                    
                if (p == end) {
                    return steps;
                }
                
                for (int q : hs) {
                    int o = p * q % 1000;
                    
                    if (done[o]) {
                        continue;
                    }
                    
                    done[o] = true;
                    dq.offer(o);
                }
            }
            
            steps++;
        }
        
        return -1;
    }
}