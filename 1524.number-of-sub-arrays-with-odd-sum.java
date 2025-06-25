/*
 * @lc app=leetcode id=1524 lang=java
 *
 * [1524] Number of Sub-arrays With Odd Sum
 */

// @lc code=start
class Solution {
    public int numOfSubarrays(int[] arr) {
        //Rule: odd sum - odd sum = even sum
        //Rule: even sum - even sum = even sum
        //Rule: odd sum - even sum = odd sum
        //Rule: even sum - odd sum = odd sum
        int odd = 0, even = 1, sum = 0;
        long ans = 0;
        for(int num : arr ){
            sum += num;
            if(sum % 2 == 0){
                //prevent overflow problem
                ans = (ans + odd) % 1000000007;
                even++;
            }
            else{
                ans = (ans + even) % 1000000007;
                odd++;
            }
        }
        return (int) ans;
    }
}
// @lc code=end

