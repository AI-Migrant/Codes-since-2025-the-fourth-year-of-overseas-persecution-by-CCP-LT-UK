class Solution {
    public ArrayList<String> generateIp(String s) {
        final ArrayList<String> answer = new ArrayList<>();
        solve(answer, s, new StringBuilder(s.length()), 0, 4);
        
        return answer;
    }
    
    
    private void solve(final ArrayList<String> answer, final String s, final StringBuilder sb, final int i, int j) {
        if (i == s.length()) {
            if (j == 0) {
                answer.add(sb.toString());
            }
            
            return;
        } else if (s.length() - i < j || s.length() - i > j * 3) {
            return;
        } else if (!sb.isEmpty()) {
            sb.append('.');
        }
        
        j--;
        
        for(int h = sb.length(), k = 1, o = Math.min(3, s.length() - i); k <= o; k++) {
            final int x = Integer.parseInt(s.substring(i, i + k));
            
            if (x > 255 || (k > 1 && s.charAt(i) == '0')) {
                break;
            }
            
            sb.append(x);
            solve(answer, s, sb, i + k, j);
            sb.setLength(h);
        }
    }
}