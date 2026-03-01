/*
 * @lc app=leetcode id=3583 lang=java
 *
 * [3583] Count Special Triplets
 */
import java.util.*;
// @lc code=start
class Solution {
    private final int MOD = 1000_000_007;
    public int specialTriplets(int[] nums) {
        
        Map<Integer, Integer> suf = new HashMap<>();
        for(int num : nums){
            suf.merge(num,1, Integer::sum);
        }
        Map<Integer, Integer> pre = new HashMap<>();
        long ans = 0;
        for(int num : nums){
            suf.merge(num, -1, Integer::sum);
            int target = 2*num;
            if(suf.containsKey(target) && pre.containsKey(target)){
                ans += (long)suf.get(target) * pre.get(target); //边界条件的敏感练习
            }
            pre.merge(num, 1, Integer::sum);
        }
        return (int) (ans % MOD);
    }
}
// @lc code=end

