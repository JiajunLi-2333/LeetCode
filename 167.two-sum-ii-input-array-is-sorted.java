/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //! 枚举右 维护左
        // Map<Integer, Integer> map = new HashMap<>();
        // for(int i = 0; i < numbers.length; i++){
        //     int comp = target - numbers[i];
        //     if(map.containsKey(comp)){
        //         return new int[]{map.get(comp) + 1, i + 1};
        //     }
        //     map.put(numbers[i], i);
        // }
        // return new int[]{-1, -1};
        
        //! 枚举优化： 双指针（有序性）
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left + 1, right + 1};
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
// @lc code=end

