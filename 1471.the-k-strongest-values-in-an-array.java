/*
 * @lc app=leetcode id=1471 lang=java
 *
 * [1471] The k Strongest Values in an Array
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int right = arr.length -1;
        int left = 0;
        int median = arr[(right)/2];
        int[] ans = new int[k];
        while(left <= right && k > 0){
            if(median - arr[left] <= arr[right] - median){
                ans[--k] = arr[right];
                right--;
            }else{
                ans[--k] = arr[left];
                left++;
            }
            
        }
        return ans;
    }
}
// @lc code=end

