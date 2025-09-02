/*
 * @lc app=leetcode id=2875 lang=java
 *
 * [2875] Minimum Size Subarray in Infinite Array
 */
class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        //! MLE
        // long total = 0; 
        // for(int x : nums){
        //     total += x;
        // }
        // List<Integer> List = new ArrayList<>(nums.length);
        // for (int x : nums) {
        //     List.add(x);
        // }  
        // int multiple = (int)Math.ceil((double)target / total);
        // for(int i = 0; i < multiple; i++){
        //     List.addAll(List);
        // }

        // int minLength = Integer.MAX_VALUE;
        // int currentSum = 0;
        // int left = 0;

        // for (int right = 0; right < List.size(); right++) {
        //     currentSum += List.get(right);
        //     while (currentSum > target) {
        //         currentSum -= List.get(left);
        //         left++;
        //     }
        //     if(currentSum == target) {
        //         minLength = Math.min(minLength, right - left + 1);
        //     } 
        // }

        // return minLength == Integer.MAX_VALUE ? -1 : minLength;

        //? Optimization: use index and modula as simulation : TLE
        // long total = 0;
        // for(int num:nums){
        //     total += num;
        // }
        // int n = nums.length;
        // int ans = Integer.MAX_VALUE;
        // long sum = 0;
        // int left = 0;
        // for(int i = 0; i < n + n * (target / total + 1); i++){
        //     sum += nums[i % n];
        //     while(sum > target){
        //         sum -= nums[left % n];
        //         left++;
        //     }
        //     if(sum == target){
        //         ans = Math.min(ans, i - left + 1);
        //     }
        // }
        // return ans == Integer.MAX_VALUE ? -1 : ans;

        //? optimization: question exploration: target = k * total + rem
        long total = 0;
        for(int num : nums){
            total += num;
        }
        int ans = Integer.MAX_VALUE;
        long sum = 0;
        int left = 0;
        int n = nums.length;

        for(int i = 0; i < 2 * n; i++){
            sum += nums[i % n];
            while(sum > target % total){
                sum -= nums[left % n];
                left++;
            }
            if(sum == target % total){
                ans = Math.min(ans, i - left + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans + (int)(target/total) * n;
    }
}
// @lc code=end

