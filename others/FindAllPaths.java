import java.util.*;

public class FindAllPaths {
    public static void main(String... args) {
        int[][] grid = new int[][]{
            {0, 0, 0, 0},
            {1, 0, 0, 0},
            {1, 0, 1, 0},
            {1, 1, 1, 0}
        };

        List<List<String>> result = new FindAllPaths().getAllPaths(grid);
        for (List<String> l : result) {
            for (String n : l) {
                System.out.println(n + " ");
            }
            System.out.println();
        }
    }

    private List<List<String>> result = new ArrayList<List<String>>();
    private int n;
    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    private List<List<String>> getAllPaths(int[][] grid) {
        n = grid.length;
        helper(grid, new int[]{0, 0}, new int[]{n - 1, n - 1}, new ArrayList<String>());
        return result;
    }

    private void helper(int[][] grid, int[] start, int[] end, ArrayList<String> currPath) {
        int x = start[0], y = start[1];
        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 1) return;

        currPath.add(x + "," + y);
        if (x == end[0] && y == end[1]) {
            result.add(new ArrayList<String>(currPath));
            currPath.remove(currPath.size() - 1);
            return;
        }
        
        for (int[] dir : dirs) {
            int x1 = x + dir[0], y1 = y + dir[1];
            boolean visited = false;

            for (String p : currPath) {
                if (p.equals(x1 + "," + y1)) visited = true;
            }
            
            if (!visited) helper(grid, new int[]{x1, y1}, end, currPath);
        }

        currPath.remove(currPath.size() - 1);
    }
}
