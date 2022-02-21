/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start
class Solution {
    private List<String> result = new ArrayList<String>();
    private boolean[][] visited;
    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        if (m == 0) return result;
        int n = board[0].length;
        visited = new boolean[m][n];
        
        Node root = new Node();
        buildTrie(words, root);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                find(board, i, j, root);
            }
        }

        return result;
    }

    private void find(char[][] board, int i, int j, Node root) {
        if (root == null) return;
        if (root.w != null) {
            result.add(root.w);
            root.w = null;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) return;
        if (visited[i][j]) return;
        
        char c = board[i][j];
        if (!root.children.containsKey(c)) return;
        visited[i][j] = true;
        
        for (int[] dir : dirs) {
            find(board, i + dir[0], j + dir[1], root.children.get(c));
        }
        visited[i][j] = false;        
    }

    private Node buildTrie(String[] words, Node root) {
        for (String word : words) {
            addToTrie(word, root);
        }
        return root;
    }

    private void addToTrie(String word, Node root) {
        helper(word, root, 0);
    }

    private void helper(String word, Node root, int index) {
        if (index == word.length()) {
            root.w = word;
            return;
        }
        
        char c = word.charAt(index);
        if (!root.children.containsKey(c)) {
            root.children.putIfAbsent(c, new Node());
        }
        helper(word, root.children.get(c), index + 1);
    }
}

class Node {
    String w;
    char c;
    Map<Character, Node> children;

    Node() {
        children = new HashMap<Character, Node>();
    }
}
// @lc code=end
