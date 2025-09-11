/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int n = nums.length, left = 0;
        for(int right = 0; right < n; right++){
            if(right == n -1 || nums[right] + 1 != nums[right + 1]){
                if(left == right){
                    ans.add(String.valueOf(nums[left]));
                } else {
                    ans.add(nums[left] + "->" + nums[right]);
                }
                left = right + 1;
            }
        }
        return ans;
        
    }
}
// @lc code=end

