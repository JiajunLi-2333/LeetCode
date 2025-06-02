/*
 * @lc app=leetcode id=3128 lang=java
 *
 * [3128] Right Triangles
 */

// @lc code=start
class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int[] rowSum = new int[grid.length]; 
        int[] colSum = new int[grid[0].length]; 
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                rowSum[i] += grid[i][j]; //Update the row sum
                colSum[j] += grid[i][j]; //Update the column sum
            }
        }

        long ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                //multiplication rule solves the problem
                if(grid[i][j] == 1){
                    // Count the number of right triangles with the right angle at (i, j)
                    long horizontal = rowSum[i] - 1; // Exclude the current cell
                    long vertical = colSum[j] - 1; // Exclude the current cell
                    ans += horizontal * vertical;
                }
            }
        }
        return ans;


    }
}
// @lc code=end

