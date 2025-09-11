/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int cur = 0;
        for(int x : nums){
            if(x != val){
                nums[cur++] = x;
            }
        }
        return cur;
    }
}
// @lc code=end

