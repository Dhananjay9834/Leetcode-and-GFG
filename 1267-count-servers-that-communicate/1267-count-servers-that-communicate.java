class Solution {
    public int countServers(int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        int rowCnt[] = new int[numRows];
        int colCnt[] = new int[numCols];

        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                if(grid[i][j] == 1){
                    rowCnt[i]++;
                    colCnt[j]++;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                if(grid[i][j] == 1){
                    if(rowCnt[i] > 1 || colCnt[j] > 1){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}