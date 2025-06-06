/*
 * @lc app=leetcode id=2216 lang=java
 *
 * [2216] Minimum Deletions to Make Array Beautiful
 */
import java.util.Stack;
// @lc code=start
class Solution {
    public int minDeletion(int[] nums) {
        int size = 0, ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(int num : nums){
            int curIndex = size - 1;
            if(size > 0 && curIndex % 2 == 0 && stack.peek() == num){
                size+=2;
                stack.push(num);
                ans++;
            }
            else{
                stack.push(num);
                size++;
            }
        }
        //I forget I need it to be even length
        if (size % 2 == 1){
            ans++;
        }
        return ans;
        
    }
}
// @lc code=end

