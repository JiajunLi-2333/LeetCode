/*
 * @lc app=leetcode id=1887 lang=java
 *
 * [1887] Reduction Operations to Make the Array Elements Equal
 */
import java.util.*;
// @lc code=start
class Solution {
    public int reductionOperations(int[] nums) {
        //这道题感觉还是验证状态更多一些 剪枝的作用并不是很大
        //更准确的说是用两个指针分组 来处理相同的逻辑
        Arrays.sort(nums);
        int n = nums.length, ans = 0;
        int right = 0, k = 0;
        while(right < n){
            int left = right;
            while(right < n && nums[right] == nums[left]) right++;
            int len = right - left;
            ans += len * k++;
        }
        return ans;

    }
}
// @lc code=end

