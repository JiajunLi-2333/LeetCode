/*
 * @lc app=leetcode id=2824 lang=java
 *
 * [2824] Count Pairs Whose Sum is Less than Target
 */
import java.util.*;
// @lc code=start
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        //枚举右 维护左可以做 但是代码实现比较的麻烦
        //使用 双指针 （排序不影响结果）候选空间剪枝 快速统计数量
        Collections.sort(nums);
        int n = nums.size();
        int left = 0, right = n - 1;
        int ans = 0;
        while(left < right){
            if(nums.get(left) + nums.get(right) < target){
                ans += right - left;
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}
// @lc code=end

