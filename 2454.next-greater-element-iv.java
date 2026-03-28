/*
 * @lc app=leetcode id=2454 lang=java
 *
 * [2454] Next Greater Element IV
 * 
 */
import java.util.*;
class Solution {
    public int[] secondGreaterElement(int[] nums) {
        // int n = nums.length;
        // int[] ans = new int[n];
        // Arrays.fill(ans, -1);
        
        // for (int i = 0; i < n; i++) {
        //     boolean met = false;
        //     for (int j = i + 1; j < n; j++) {
        //         if (nums[j] > nums[i]) {
        //             if (met) {
        //                 ans[i] = nums[j];
        //                 break;
        //             }
        //             met = true;
        //         }
        //     }
        // }
        // return ans;
        Deque<Integer> firstBigger = new ArrayDeque<>();
        Deque<Integer> secondBigger = new ArrayDeque<>();
        int n = nums.length; 
        int[] ans = new int[n];
        
        Arrays.fill(ans, -1);
        for(int i = 0; i < n; i++){
            int num = nums[i];
            while(!secondBigger.isEmpty() && num > nums[secondBigger.peek()]){
                ans[secondBigger.pop()] = num;
            }
            List<Integer> out = new ArrayList<>();
            while(!firstBigger.isEmpty() && num > nums[firstBigger.peek()]){
                out.add(firstBigger.pop());
            }
            int len = out.size(); 
            for(int j = len -1; j >= 0; j--){
                secondBigger.push(out.get(j));
            }
            firstBigger.push(i);
        }
        return ans;
    }
}// @lc code=end

