class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        final int n = a1.length;
        final HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);
        int answer = 0;
        
        for (int i = 0, sum = 0; i < n; i++) {
            sum += a1[i] - a2[i];
            
            if (hashMap.containsKey(sum)) {
                answer = Math.max(answer, i - hashMap.get(sum));
            } else {
                hashMap.put(sum, i);
            }
        }
        
        return answer;
    }
}