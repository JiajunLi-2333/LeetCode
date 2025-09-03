/*
 * @lc app=leetcode id=658 lang=java
 *
 * [658] Find K Closest Elements
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        int remove = arr.length - k;

        while(remove > 0){
            if(x - arr[left] <= arr[right] - x){
                right--;
            }else{
                left++;
            }
            remove--;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = left; i < left + k; i++){
            ans.add(arr[i]);
        }
        return ans; 
    }
}
// @lc code=end

