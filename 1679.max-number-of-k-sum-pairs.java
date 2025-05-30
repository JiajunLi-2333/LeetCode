/*
 * @lc app=leetcode id=1679 lang=java
 *
 * [1679] Max Number of K-Sum Pairs
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int num : nums){
            int complement = k - num;
            if(map.containsKey(complement) && map.get(complement) > 0){
                ans++;
                map.put(complement, map.get(complement) - 1);
                if(map.get(complement) == 0) {
                    map.remove(complement);
                }
                continue;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return ans;

    }
}
// @lc code=end

