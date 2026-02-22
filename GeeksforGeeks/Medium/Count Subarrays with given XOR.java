class Solution {
    public long subarrayXor(int arr[], int k) {
        final HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int answer = 0;
        int prefix = 0;
        
        for (final int num : arr) {
            prefix ^= num;
            answer += hashMap.getOrDefault(prefix ^ k, 0);
            hashMap.put(prefix, hashMap.getOrDefault(prefix, 0) + 1);
        }
        
        return answer;
    }
}