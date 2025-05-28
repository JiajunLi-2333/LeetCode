/*
 * @lc app=leetcode id=1512 lang=java
 *
 * [1512] Number of Good Pairs
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num:nums){
            if(map.containsKey(num)){
                ans += map.get(num); 
                map.merge(num, 1, Integer::sum);
            }else{
                map.put(num, 1);
            }
        }
        return ans;

    }
}
// @lc code=end

