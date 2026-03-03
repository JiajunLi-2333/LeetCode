/*
 * @lc app=leetcode id=636 lang=java
 *
 * [636] Exclusive Time of Functions
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Integer> stack = new ArrayDeque<>();//store the idx of the function
        int[] ans = new int[n];
        int cur = -1; //this remembers the last timestamp
        for(String log : logs){
            String[] ss = log.split(":");
            int idx = Integer.parseInt(ss[0]), ts = Integer.parseInt(ss[2]);//ss[1] indicates start or end
            if(ss[1].equals("start")){
                if(!stack.isEmpty()) ans[stack.peek()] += ts - cur;
                stack.push(idx);
                cur = ts;
            }else{
                int index = stack.pop();
                ans[index] += ts - cur + 1;
                cur = ts + 1;
            }
        }
        return ans;
    }
}
// @lc code=end

