class Solution {
    public static int[][] graph = new int[301][301];
    public static int n, m;

    public int numIslands(char[][] grid) {
        int result = 0;
        n = grid.length;
        m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = grid[i][j] - '0';
            }
        }        
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(dfs(i,j)) result += 1;
            }
        }
        
        return result;
    }
    
    public static boolean dfs(int x, int y){
        if (x <= -1 || x >= n || y <= -1 || y >= m) {
            return false;
        }
        if(graph[x][y] == 1){
            graph[x][y] = 0;

            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y + 1);
            dfs(x, y - 1);
            return true;
        }
        return false;
    }
}