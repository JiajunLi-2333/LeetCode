/*
 * @lc app=leetcode id=457 lang=java
 *
 * [457] Circular Array Loop
 */

// @lc code=start
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            //identify the slow and fast pointers
            int slow = i;
            int fast = next(nums, i);

            while(nums[slow] * nums[fast] > 0 && nums[fast] * nums[next(nums,fast)] > 0){
                if (slow == fast){
                    if(slow != next(nums, slow)){
                        return true;
                    }else{
                        break;
                    }
                }
                slow = next(nums,slow);
                fast = next(nums,next(nums,fast));
            }
        }
        return false;
    }
    private int next(int[] nums, int i){
        int n = nums.length;
        return((i + nums[i]) % n + n ) % n;
    }
}
// @lc code=end

