class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        final ArrayDeque<Integer> p = new ArrayDeque<>();
        final int n = q.size() / 2;
        
        for (int i = 0; i < n; i++) {
            p.offerLast(q.poll());
        }
        
        for (int i = 0; i < n; i++) {
            q.offer(p.poll());
            q.offer(q.poll());
        }
    }
}