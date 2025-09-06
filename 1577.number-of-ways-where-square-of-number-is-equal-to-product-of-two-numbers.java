/*
 * @lc app=leetcode id=1577 lang=java
 *
 * [1577] Number of Ways Where Square of Number Is Equal to Product of Two Numbers
 */
import java.util.*;
// @lc code=start
class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        // return getCnt(nums1, nums2) + getCnt(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return getCnt(nums1, nums2) + getCnt(nums2, nums1);
        
    }
    // private int getCnt(int[] nums1, int[] nums2) {
    //     Map<Long, Integer> map = new HashMap<>();
    //     for (int n : nums2) {
    //         long square = (long)n * n;
    //         map.put(square, map.getOrDefault(square, 0) + 1);
    //     }
    //     int cnt = 0;
    //     for (int i = 0; i < nums1.length; i++) {
    //         for (int j = i + 1; j < nums1.length; j++) {
    //             long product = (long)nums1[i] * nums1[j];
    //             cnt += map.getOrDefault(product, 0);
    //         }
    //     }
    //     return cnt;
    // }
    private int getCnt(int[] nums1, int[] nums2){
        int cnt = 0;
        for(int i = 0; i < nums1.length;i++){
            long square = (long) nums1[i] * nums1[i];
            int left = 0, right = nums2.length -1;
            while(left < right){
                long product = (long) nums2[left] * nums2[right];
                if(product > square){
                    right--;
                } else if(product < square){
                    left++;
                } else {
                    if(nums2[left] == nums2[right]){
                        int size = right - left + 1;
                        cnt += size * (size - 1) / 2;
                        break;
                    }
                    else{
                        int leftCnt = 1, rightCnt = 1;
                        while(left + 1 < right && nums2[left] == nums2[left + 1]){
                            leftCnt++;
                            left++;
                        }
                        while(right - 1 > left && nums2[right] == nums2[right - 1]){
                            rightCnt++;
                            right--;
                        }
                        cnt += leftCnt * rightCnt;
                        left++;
                        right--;
                    }
                }
            }
        }
        return cnt;
    }
    
}
// @lc code=end

