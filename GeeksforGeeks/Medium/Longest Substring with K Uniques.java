class Solution {
    public int longestKSubstr(String s, int k) {
        final int n = s.length();
        final char[] a = s.toCharArray();
        final HashMap<Character, Integer> hashMap = new HashMap<>();
        int i = 0;
        int j = 0;
        
        while (hashMap.size() < k && i < n) {
            hashMap.put(a[i], hashMap.getOrDefault(a[i++], 0) + 1);
        }
        
        if (hashMap.size() < k) {
            return -1;
        }
        
        int answer = i ;
        
        while (i < n) {
            hashMap.put(a[i], hashMap.getOrDefault(a[i], 0) + 1);
            
            while (hashMap.size() > k) {
                if (hashMap.get(a[j]).equals(1)) {
                    hashMap.remove(a[j++]);
                } else {
                    hashMap.put(a[j], hashMap.get(a[j++]) - 1);
                }
            }
            
            answer = Math.max(answer, ++i - j);
        }
        
        return answer;
    }
}