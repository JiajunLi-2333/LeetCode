
import java.util.*;
// @lc code=start
class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int m = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] != nums[i -1]){
                nums[m++] = nums[i]; // remove duplicates in place
            }
        }

        int ans = 0;
        int left = 0;
        for(int i = 0; i < m; i++){
            while(nums[i] - nums[left] > n -1){
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return n - ans;
    }
}
// @lc code=end

