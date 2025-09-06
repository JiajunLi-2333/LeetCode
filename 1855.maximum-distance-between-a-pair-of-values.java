/*
 * @lc app=leetcode id=1855 lang=java
 *
 * [1855] Maximum Distance Between a Pair of Values
 */

// @lc code=start
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0; 
        int i = 0, j = 0; 
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                ans = Math.max(ans, j - i);
                j++;
            }else{
                i++;
            }
        }
        return ans;
    }
}
// @lc code=end

