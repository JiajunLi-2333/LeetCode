/*
 * @lc app=leetcode id=2540 lang=java
 *
 * [2540] Minimum Common Value
 */

// @lc code=start
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        while(i < nums1.length && nums2.length > j){
            if(nums1[i] == nums2[j]){
                return nums1[i];
            } else if(nums1[i] < nums2[j]){
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }
}
// @lc code=end

