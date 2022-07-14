/*
 * @lc app=leetcode id=348 lang=java
 *
 * [348] Design Tic-Tac-Toe
 */

// @lc code=start
class TicTacToe {

    private int[] r;
    private int[] c;
    private int d;
    private int d1;
    private int n;
    
    public TicTacToe(int n) {
        r = new int[n];
        c = new int[n];
        d = 0; d1 = 0;
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        int m = ((player == 1) ? 1 : -1);

        if (row == col) {
            d += m;
        }

        if (row + col == n - 1) {
            d1 += m;
        }

        r[row] += m;
        c[col] += m;
        
        if (Math.abs(d) == n || Math.abs(d1) == n
            || Math.abs(r[row]) == n || Math.abs(c[col]) == n) return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
// @lc code=end
