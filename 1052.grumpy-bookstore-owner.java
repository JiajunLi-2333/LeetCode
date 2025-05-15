/*
 * @lc app=leetcode id=1052 lang=java
 *
 * [1052] Grumpy Bookstore Owner
 */

// @lc code=start
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;
        for(int i = 0; i < customers.length; i++){
            if(grumpy[i] == 0){
                sum += customers[i];
            }
        }

        int result = sum;
        for(int i = 0; i < grumpy.length; i++){
            if(grumpy[i] == 1){
                sum += customers[i];
            }
            if(i < minutes - 1){
                continue; 
            }
            result = Math.max(result, sum);
            sum -= grumpy[i - minutes + 1] == 1 ? customers[i - minutes + 1]: 0;
        }
        return result;

    }
}
// @lc code=end

