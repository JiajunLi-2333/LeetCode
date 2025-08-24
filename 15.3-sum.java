/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //! 枚举 + 双指针
        //solve the duplication problem
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        

        for(int k = n -1; k > 0; k--){
            if(k < n - 1 && nums[k] == nums[k + 1]) continue;
            int i = 0;
            int j = k -1;
            while(i < j){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // 跳过与当前 i、j 相同的值，避免同一 k 下重复
                    int li = nums[i], lj = nums[j];
                    while (i < j && nums[i] == li) i++;
                    while (i < j && nums[j] == lj) j--;
                }
                else if(sum > 0){
                    j--;
                }else{
                    i++;
                }
            }
        }

        return ans;
    }
}
// @lc code=end

