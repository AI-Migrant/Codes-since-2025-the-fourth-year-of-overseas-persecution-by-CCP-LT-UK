class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        final int n = arr1.length;
        final int m = arr2.length;
        final ArrayList<Integer> answer = new ArrayList<>(2);
        answer.add(0);
        answer.add(0);
        
        for (int i = 0, j = m - 1, d = Integer.MAX_VALUE, e, y; i < n && j >= 0;) {
            y = arr1[i] + arr2[j];
            e = Math.abs(x - y);
            
            if (e < d) {
                d = e;
                answer.set(0, i);
                answer.set(1, j);
            }
            
            if (x > y) {
                i++;
            } else {
                j--;
            }
        }
        
        answer.set(0, arr1[answer.get(0)]);
        answer.set(1, arr2[answer.get(1)]);
        
        return answer;
    }
}
