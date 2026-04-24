class Solution {
    public int visibleBuildings(int arr[]) {
        int answer = 0;
        int h = 0;
        
        for (final int height : arr) {
            if (height >= h) {
                answer++;
                h = height;
            }
        }
        
        return answer;
    }
}