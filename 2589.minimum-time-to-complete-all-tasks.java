/*
 * @lc app=leetcode id=2589 lang=java
 *
 * [2589] Minimum Time to Complete All Tasks
 */

// @lc code=start
import java.util.*;
//! Basic version only, more attension needed 
class Solution {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a,b) -> a[1] - b[1]);
        int ans = 0; 

        int mx = tasks[tasks.length - 1][1];
        boolean[] run = new boolean[mx + 1];
        
        for(int[] task : tasks){
            int start = task[0]; 
            int end = task[1];
            int d = task[2];

            for(int i = start; i <= end; i++){
                if(run[i]) {
                    d--; 
                }
            }

            for(int i = end; d > 0; i--){
                if(!run[i]){
                    run[i] = true; 
                    d--;
                    ans++;
                } 
            }
        }
        return ans;
    }
}
// @lc code=end

