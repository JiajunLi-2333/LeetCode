
import java.util.List;

/*
 * @lc app=leetcode id=624 lang=java
 *
 * [624] Maximum Distance in Arrays
 */

// @lc code=start
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int ans = 0;
        int min = Integer.MAX_VALUE / 2;
        int max = Integer.MIN_VALUE / 2;
        for(List<Integer> array:arrays){
            int first= array.get(0);
            int last = array.get(array.size() - 1);
            ans = Math.max(ans, Math.max(last - min, max - first));
            min = Math.min(min, first);
            max = Math.max(max, last);
        }
        return ans;
    }
}
// @lc code=end

