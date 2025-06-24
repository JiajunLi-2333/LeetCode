/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */
import java.util.HashMap;
import java.util.Map;
// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {

        //! unable to use left and right pointers because of the negative numbers
        //! we cannot know when to move the left pointer, as the sum can decrease with negative numbers
        // if(nums == null || nums.length == 0) return 0;
        // if(k == 0 && nums.length == 1 && nums[0] > 0) return 0;
        // int ans = 0, left = 0, right = 0, sum = 0;
        // while(right < nums.length){
        //     sum += nums[right];
        //     right++;
        //     while(sum > k && left < right){
        //         sum -= nums[left];
        //         left++;
        //     }
        //     if(sum == k){
        //         ans++;
        //         int tempLeft = left;
        //         while(tempLeft < right && nums[tempLeft] == 0){
        //             ans++;
        //             tempLeft++;
        //         }
        //     }
        // }
        // return ans;
        
        //todo use hashmap and prefix sum
        int ans = 0, n = nums.length;
        int[] prefix = new int[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // to handle the case where the prefix sum itself is equal to k
        for(int i = 0; i < n; i++){
            prefix[i+ 1] = prefix[i] + nums[i];
        }
        for(int i = 0; i < n; i++){
            int complement = prefix[i + 1] - k;
            if(map.containsKey(complement)){
                ans += map.get(complement);
            }
            map.put(prefix[i + 1], map.getOrDefault(prefix[i + 1], 0) + 1);
        }
        return ans;
    }
}
// @lc code=end

