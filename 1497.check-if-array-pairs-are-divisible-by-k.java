/*
 * @lc app=leetcode id=1497 lang=java
 *
 * [1497] Check If Array Pairs Are Divisible by k
 */
import java.util.HashMap;
import java.util.Map;
// @lc code=start
class Solution {
    public boolean canArrange(int[] arr, int k) {
        int ans = 0, n = arr.length; 
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : arr){
            int res = ((num % k) + k) % k;
            int rem = (k -res) % k;
            if(map.containsKey(rem)){
                ans++;
                map.merge(rem, -1, Integer::sum);
                if(map.getOrDefault(rem, 0) == 0){
                    map.remove(rem);
                }
            }else{
                map.merge(res, 1, Integer::sum);
            }
        }
        return ans == n/2;

    }
}
// @lc code=end

