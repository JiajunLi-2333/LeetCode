/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 */
import java.util.HashMap;
import java.util.Stack;
// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums2.length;
        int[] ans = new int[nums1.length];
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for(int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
// @lc code=end

