/*
 * @lc app=leetcode id=2537 lang=java
 *
 * [2537] Count the Number of Good Subarrays
 */
import java.util.*;
// @lc code=start
class Solution {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            int c = map.getOrDefault(nums[right], 0);
            pairs += c;
            map.put(nums[right], c + 1);
            while(pairs >= k){
                int d = nums[left++];
                pairs -= map.get(d) - 1;
                map.put(d, map.get(d) - 1);
                if(map.get(d) == 0){
                    map.remove(d);
                }
            }
            ans += left;
        }
        return ans;
        
    }
}
// @lc code=end

