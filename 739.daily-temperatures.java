/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //clarification
        

        //constriants
        // 1 <= temperatures.length <= 10^5;
        // 30 <= temperature[i] <= 100; 

        //edge cases
        //tem = [30] return [0];
        //tem = [.........] -> [.......]
        //tem = [1,2,3,4,5,6] -> [....0]
        //tem = [6,5,4,3,2,1] -> [0000000] all zeros
        //tem = [3,3,3,3,3,3,3] -> [0,0,0,0,0,0] all zeros
        //tem = [6,5,4,3,2,1,7,8,9,10,11]
        //tem = [3,2,1,4,5,3,2,7] -> [3,2,1,1,3,2,1,0]

        //solutioin: intuitive
        //nested for loops -> O(n^2)
        //优化方向：增量变化 -> 动态维护

        Deque<Integer> stack = new ArrayDeque<>();//monotonic decreasing stack
        int n = temperatures.length; 
        int[] ans = new int[n];
        Arrays.fill(ans, 0);
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index = stack.pop();
                ans[index] = i - index; 
            }
            stack.push(i);
        }
        return ans;
    }
}
// @lc code=end

