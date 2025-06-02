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
        List<String> ans = new ArrayList<>();
        int index = 0;
        for(int i = 1; i <= n && index < target.length; i++){ // you can add different variables to judge the condition here
            ans.add("Push");
            if(target[index] != i){
                ans.add("Pop");
            }else{
                index++;
            }
        }
        return ans;
    }
}
// @lc code=end

