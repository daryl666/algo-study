package practice.search;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/24 17:55
 */
public class WordSearch {

    private static int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int m;
    static int n;
    static boolean exist = false;

    public static boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs2(board, new StringBuilder(), i, j, visited, word);
                if (exist) {
                    return true;
                }
            }
        }
        return exist;
    }

    public static void dfs(char[][] board, StringBuilder prefix, int r, int c, boolean[][] visited, String word) {
        if (word.equals(prefix.toString())) {
            exist = true;
            return;
        }
        if (visited[r][c]) {
            return;
        }
        if (prefix.length() == word.length()) {
            return;
        }
        for (int[] direction : directions) {
            if (r + direction[0] < 0 || r + direction[0] >= m || c + direction[1] < 0 || c + direction[1] >= n) {
                continue;
            }
            visited[r][c] = true;
            prefix.append(board[r + direction[0]][c + direction[1]]);
            dfs(board, prefix, r + direction[0], c + direction[1], visited, word);
            visited[r][c] = false;
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }


    public static void dfs2(char[][] board, StringBuilder prefix, int r, int c, boolean[][] visited, String word) {
        prefix.append(board[r][c]);
        if (word.equals(prefix.toString())) {
            exist = true;
            return;
        }
        if (visited[r][c]) {
            prefix.deleteCharAt(prefix.length() - 1);
            return;
        }
        if (prefix.length() == word.length()) {
            prefix.deleteCharAt(prefix.length() - 1);
            return;
        }
        visited[r][c] = true;
        for (int[] direction : directions) {
            if (r + direction[0] < 0 || r + direction[0] >= m || c + direction[1] < 0 || c + direction[1] >= n) {
                continue;
            }
            dfs2(board, prefix, r + direction[0], c + direction[1], visited, word);
        }
        prefix.deleteCharAt(prefix.length() - 1);
        visited[r][c] = false;

    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "SEECCBFSD"));

    }

}