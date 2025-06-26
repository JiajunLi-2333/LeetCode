/*
 * @lc app=leetcode id=3026 lang=java
 *
 * [3026] Maximum Good Subarray Sum
 */
import java.util.*;
// @lc code=start
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        //! logically correct but TLE
        // long sum = Long.MIN_VALUE;
        // Map<Integer, List<Integer>> map = new HashMap<>();
        // int n = nums.length;
        // long[] preSum = new long[n +1];
        // for(int i = 0; i < n; i++){
        //     preSum[i + 1] = preSum[i] + (long) nums[i];
        //     if(!map.containsKey(nums[i])){
        //         map.put(nums[i], new ArrayList<>());
        //         map.get(nums[i]).add(i);
        //     }
        //     else{
        //         map.get(nums[i]).add(i);
        //     }
        // }

        // for(int i = 0; i < n; i++){
        //     int num = nums[i];
        //     int left = num - k;
        //     int right = num + k;
        //     if(map.containsKey(left)){
        //         for(int index : map.get(left)){
        //             if(index < i){
        //                 sum = Math.max(sum, preSum[i + 1] - preSum[index]);
        //             }
        //             else{
        //                 sum = Math.max(sum, preSum[index + 1] - preSum[i]);
        //             }
        //         }
        //     }
        //     if(map.containsKey(right)){
        //         for(int index : map.get(right)){
        //             if(index < i){
        //                 sum = Math.max(sum, preSum[i + 1] - preSum[index]);
        //             }
        //             else{
        //                 sum = Math.max(sum, preSum[index + 1] - preSum[i]);
        //             }
        //         }
        //     }
        // }
        // return sum == Long.MIN_VALUE ? 0 : sum;
        
        //todo An upgarde to the above code, the logic is the same but we greedily update the index of the number stored in the map
        // int n = nums.length;
        // long[] preSum = new long[n + 1];
        // for (int i = 0; i < n; i++) {
        //     preSum[i + 1] = preSum[i] + nums[i];
        // }
        // long ans = Long.MIN_VALUE;
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < n; i++) {
        //     int num = nums[i];
        //     int left = num - k;
        //     int right = num + k;
        //     if (map.containsKey(left)) {
        //         int index = map.get(left);
        //         ans = Math.max(ans, preSum[i + 1] - preSum[index]);
        //     }
        //     if (map.containsKey(right)) {
        //         int index = map.get(right);
        //         ans = Math.max(ans, preSum[i + 1] - preSum[index]);
        //     }
        //     if (map.containsKey(num)){
        //         int index = map.get(num);
        //         long sum = preSum[i] - preSum[index];
        //         if(sum <= 0){
        //             map.put(num, i);
        //         }
        //     }
        //     else {
        //         map.put(num, i);
        //     }
        // }
        // return ans == Long.MIN_VALUE ? 0 : ans;
        //! The ultimate solution: preSum and status memorization, just remember the minimum prefix sum of the current number 
        long ans = Long.MIN_VALUE;
        long sum = 0;
        Map<Integer, Long> map = new HashMap<>();
        for(int x: nums){
            long s1 = map.getOrDefault(x - k, Long.MAX_VALUE / 2);
            long s2 = map.getOrDefault(x + k, Long.MAX_VALUE / 2);
            ans = Math.max(ans, sum + x - Math.min(s1, s2));
            map.merge(x, sum, Math::min);
            sum += x;
        }
        return ans > Long.MIN_VALUE / 4 ? ans : 0;


    }
}
// @lc code=end

