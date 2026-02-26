/*
 * @lc app=leetcode id=3371 lang=java
 *
 * [3371] Identify the Largest Outlier in an Array
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
class Solution {
    public int getLargestOutlier(int[] nums) {
        //clarifition 
        //Given the integer array nums, we have One sum number, One outlier, and N - 2 special numbers. sum of special numbers = sum number

        //constriants
        // 3 <= nums.length <= 10^5
        // -1000 <= nums[i] <= 1000
        // It is garaunteed that at least one potential outlier exists in nums

        //edge cases 
        //nums = [1,1,1,1,4,25] -> 25 There is only one outlier neat condition
        //nums = [0,0,0] -> 0
        //nums = [1,2,3,5] outliers= {1,5} max(outlier) = 5

        //Solution: Intuitive
        // total - outlier = 2 * sum
        // Map<Integer, Integer> map = new HashMap<>();
        // int total = 0;
        // for(int x : nums){
        //     total += x;
        //     map.merge(x, 1, Integer::sum);
        // }
        // int ans = Integer.MIN_VALUE;
        // for(int x : nums){
        //     map.merge(x,-1, Integer::sum);
        //     if((total - x) % 2 == 0 && map.getOrDefault((total - x)/2,0) > 0){
        //         ans = Math.max(ans, x);
        //     }
        //     map.merge(x, 1, Integer::sum);
        // }
        // return ans;

        //利用有序性提前做排除
        Arrays.sort(nums);
        int total = 0;
        for(int x : nums){
            total += x;
        }

        int outlier = 0, sum = nums.length - 1, ans = Integer.MIN_VALUE;
        while(outlier < nums.length && sum >= 0){
            int x = total - nums[outlier] - 2*nums[sum];
            if(x > 0){
                outlier++;
            }else if(x < 0){
                sum--;
            }else{
                if(outlier != sum){
                    ans = nums[outlier];
                }
                outlier++;
                sum--;
            }
        }
        return ans;
    }
}
// @lc code=end

