class Solution {
    public int minPathSum(int[][] grid) {

        int rowSize = grid.length;
        int colSize = grid[0].length;
        int d[][] = new int[rowSize][colSize];

        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                if (r == 0 && c == 0) {
                    d[r][c] = grid[r][c];
                } else if (r == 0) {
                    d[r][c] = d[r][c-1] + grid[r][c];
                } else if (c == 0) {
                    d[r][c] = d[r-1][c] + grid[r][c];
                }else{
                    d[r][c] = Math.min(d[r][c-1], d[r-1][c]) + grid[r][c];
                }
            }
        }
        return d[rowSize-1][colSize-1];
    }
}