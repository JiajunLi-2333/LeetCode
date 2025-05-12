/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */
import java.util.HashMap;
// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap solution
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for( int i = 0; i < nums.length; i++){
        //     int complement = target - nums[i];
        //     if(map.containsKey(complement))
        //         return new int[] {map.get(complement), i};
        //     map.put(nums[i], i);
        // }
        // return new int[] {0, 0};

        // Brute force solution
        for(int i = 0; i < nums.length -1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i, j};// the {} is the array initializer shorthand
                }
            }
        }
        return new int[] {};

    }
}
// @lc code=end

