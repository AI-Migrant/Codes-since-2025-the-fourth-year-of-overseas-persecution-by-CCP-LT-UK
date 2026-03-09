class Solution {
    public String largestSwap(String s) {
        final char[] c = s.toCharArray();
        final int n = c.length;
        final int[] a = new int[10];
        
        for (int i = n - 1; i > 0; i--) {
            final int j = c[i] - '0';
            
            if (a[j] == 0) {
                a[j] = i;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 9; j > c[i] - '0'; j--) {
                if (a[j] > i) {
                    final char temp = c[i];
                    c[i] = c[a[j]];
                    c[a[j]] = temp;
                    
                    return new String(c);
                }
            }
        }
        
        return s;
    }
}