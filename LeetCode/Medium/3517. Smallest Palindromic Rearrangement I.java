class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int o = n / 2;
        char[] arr = s.substring(0, o).toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(o);
        sb.append(arr);

        return sb.toString() + (n % 2 > 0 ? s.charAt(o) : "") + sb.reverse().toString();
    }
}