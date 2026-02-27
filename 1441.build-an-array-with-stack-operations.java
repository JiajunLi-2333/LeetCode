/*
 * @lc app=leetcode id=1441 lang=java
 *
 * [1441] Build an Array With Stack Operations
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<String> buildArray(int[] target, int n) {
        //clarification 
        //we need to fill and modify an empty stack with n integers to make the stack == target, return the operations (Push Pop) needed

        //constriants
        //1 <= target.length <= 100
        //target is increasing
        //1 <= n <= 100
        //1 <= target[i] <= n

        List<String> ans = new ArrayList<>();
        int mx = target[target.length - 1];
        int i = 0;
        for(int x = 1; x <= mx; x++){
            ans.add("Push");
            if(x == target[i]){
                i++;
            }
            else{
                ans.add("Pop" );
            }
        }
        return ans;
    }
}
// @lc code=end

