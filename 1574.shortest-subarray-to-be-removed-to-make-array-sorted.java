/*
 * @lc app=leetcode id=1574 lang=java
 *
 * [1574] Shortest Subarray to be Removed to Make Array Sorted
 */

// @lc code=start
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int right = n - 1;
        while(right > 0 && arr[right - 1] <= arr[right]){
            right--;
        }
        if(right == 0) return 0;
        int ans = right;
        int left = 0;
        while(left < n && (left == 0 || arr[left] >= arr[left - 1])){
            while(right < n && arr[right] < arr[left]){
                right++;
            }
            ans = Math.min(ans, right - left - 1);
            left++;
        }
        return ans;
    }
}
// @lc code=end

