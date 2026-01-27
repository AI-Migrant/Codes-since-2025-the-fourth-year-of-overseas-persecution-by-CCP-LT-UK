class Solution {
    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private HashMap<Character, Integer> hashMap;
    private char[][] mat;
    private boolean[][] visited;
    private int n, m;
    private String word;


    public boolean isWordExist(char[][] mat, String word) {
        this.mat = mat;
        this.word = word;
        n = mat.length;
        m = mat[0].length;
        visited = new boolean[n][m];
        hashMap = new HashMap<>();
        word.chars().forEach(c -> hashMap.put((char) c, hashMap.getOrDefault((char) c, 0) + 1));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0) && solve(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean solve(final int i, final int j, int k) {
        k++;

        if (k == word.length()) {
            return true;
        } else {
            visited[i][j] = true;
        }

        for (final int[] d : dir) {
            final int x = i + d[0];
            final int y = j + d[1];

            if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y] && mat[x][y] == word.charAt(k) && solve(x, y, k)) {
                return true;
            }
        }

        visited[i][j] = false;

        return false;
    }
}