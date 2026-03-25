/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //递减栈维护 + map
        Deque<Integer> stackInc = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            map.put(nums1[i], i);
        }
        for(int i = nums2.length - 1; i >= 0; i--){
            while(!stackInc.isEmpty() && nums2[i] > stackInc.peek()){
                stackInc.pop();
            }
            Integer idx = map.get(nums2[i]);
            if(idx != null){
                Integer top = stackInc.peek();
                ans[idx] = (stackInc.isEmpty() || top == null) ? -1 : top;
            }
            stackInc.push(nums2[i]);
        }
        return ans;
    }
}
// @lc code=end

 