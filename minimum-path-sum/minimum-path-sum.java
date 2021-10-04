class Solution {
    public int minPathSum(int[][] grid) {

        int rowSize = grid.length;
        int colSize = grid[0].length;
        int d[][] = new int[rowSize][colSize];

        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                if (r == 0 && c == 0) {
                    d[r][c] = grid[r][c];
                }else{
                    d[r][c] = Math.min(getD(r-1, c, d), getD(r, c-1, d)) + grid[r][c];
                }
            }
        }

        return d[rowSize-1][colSize-1];
    }

    private int getD(int row, int col, int[][] d) {
        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }

        return d[row][col];
    }
}