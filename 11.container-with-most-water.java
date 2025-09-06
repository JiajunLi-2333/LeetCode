/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        //! 枚举 + 双指针剪枝
        int max = 0;
        int left = 0, right = height.length -1;
        while(left < right){
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
// @lc code=end

