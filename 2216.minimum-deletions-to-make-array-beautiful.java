/*
 * @lc app=leetcode id=2216 lang=java
 *
 * [2216] Minimum Deletions to Make Array Beautiful
 */
import java.util.*;
// @lc code=start
class Solution {
    // public int minDeletion(int[] nums) {
    //     Deque<Integer> stack = new ArrayDeque<>();
    //     int ans = 0;
    //     for(int num : nums){
    //         if(!stack.isEmpty() && stack.size() % 2 == 1 && stack.peek() == num){
    //             ans++;
    //         }else{
    //             stack.push(num); 
    //         }
    //     }
    //     if(stack.size() %2 ==1){
    //         ans++;
    //     }
    //     return ans;  
    // }

    //?栈思想上的优化方案
    public int minDeletion(int[] nums) {
    int ans = 0, size = 0;
    for (int i = 0; i < nums.length; i++) {
        if (size % 2 == 0 && i + 1 < nums.length && nums[i] == nums[i + 1]) {
            ans++; // 删掉当前元素
        } else {
            size++; // 保留当前元素
        }
    }
    if (size % 2 == 1) ans++;
    return ans;
}
}
// @lc code=end

