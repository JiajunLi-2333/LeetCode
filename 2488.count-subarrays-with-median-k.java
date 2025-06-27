/*
 * @lc app=leetcode id=2488 lang=java
 *
 * [2488] Count Subarrays With Median K
 */
import java.util.*;
// @lc code=start
class Solution {
    public int countSubarrays(int[] nums, int k) {
        int pos = 0, n = nums.length, sum = 0, ans = 0;
        // Find the position of k in nums
        for(int i = 0; i < n; i++) if(nums[i] == k) {pos = i; break;}
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        // deal with the right hand side of target k
        for(int i = pos + 1; i < n; i++){
            sum += nums[i] > k ? 1 : -1;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        ans = map.getOrDefault(0, 0) + map.getOrDefault(1, 0);
        //reset the sum and deal with the left hand side of target k
        sum = 0;
        for(int i = pos -1; i >= 0; i--){
            sum += nums[i] > k ? -1 : 1;
            ans = ans + map.getOrDefault(sum, 0) + map.getOrDefault(sum + 1,0);
        }
        return ans;

    }
}
// @lc code=end

