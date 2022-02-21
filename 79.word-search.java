/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0) return false;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, i, j, word, visited, 0)) return true;
            }
        }
        
        return false;
    }

    private boolean helper(char[][] board, int i, int j,
                           String word, boolean[][] visited, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) return false;
        
        if (visited[i][j]) return false;
        visited[i][j] = true;

        if (board[i][j] != word.charAt(index)) {
            visited[i][j] = false;
            return false;
        }

        for (int[] dir : dirs) {
            if (helper(board, i + dir[0], j + dir[1], word, visited, index + 1))
                return true;
        }
        visited[i][j] = false;
        return false;
    }
}
// @lc code=end
