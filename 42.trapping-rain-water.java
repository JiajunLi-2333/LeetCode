/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        //! 解法一：DP前后缀分解
        // int n = height.length;
        // int[] preMax = new int[n];
        // int[] sufMax = new int[n];

        // preMax[0] = height[0];
        // for(int i = 1; i < n; i++){
        //     preMax[i] = Math.max(preMax[i - 1], height[i]);
        // }
        // sufMax[n - 1] = height[n - 1];
        // for(int i = n - 2; i >= 0; i--){
        //     sufMax[i] = Math.max(sufMax[i + 1], height[i]);
        // }
        // int ans = 0;
        // for(int i = 0; i < n; i++){
        //     ans += Math.min(preMax[i], sufMax[i]) - height[i];
        // }
        // return ans;
        //! 解法二：双指针 逻辑基本和解法类似，就是可以优化以下空间复杂度
        //! 关键性质在于较小的一边决定了能解多少水。所以谁小谁移动
        int n = height.length;
        int preMax = 0, sufMax = 0;
        int left = 0, right = n - 1; 
        int ans = 0; 
        while(left < right){
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            if(preMax < sufMax){
                ans += preMax - height[left];
                left++;
            }
            else{
                ans += sufMax - height[right];
                right--;
            }
        }
        return ans;
        
    }
}
// @lc code=end

