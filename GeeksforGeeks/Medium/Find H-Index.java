class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        final int n = citations.length;
        int answer = 1;
        
        while (answer <= n && citations[n - answer] >= answer) {
            answer++;
        }
        
        return answer - 1;
    }
}