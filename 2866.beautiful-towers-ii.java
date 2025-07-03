/*
 * @lc app=leetcode id=2866 lang=java
 *
 * [2866] Beautiful Towers II
 */
import java.util.Stack;
// @lc code=start
class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        //convert list to array for easier manipulation
        int[] maxH = maxHeights.stream().mapToInt(i -> i).toArray();
        int n = maxH.length;
        long sum = 0;

        //Define suffix as the max sum of heights from i to n -1
        long[] suffix = new long[n + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        //! need monotonic stack to calculate the max sum of heights as suffix
        for(int i = n -1; i >= 0; i--){
            int x = maxH[i];
            while(stack.size() > 1 && maxH[stack.peek()] >= x){
                int j = stack.pop();
                sum -= (long) maxH[j] * (stack.peek() - j);
            }
            sum += (long) x * (stack.peek() - i);
            suffix[i] = sum;
            stack.push(i);
        }

        long ans = sum;
        stack.clear();
        stack.push(-1);
        sum = 0;
        for(int i = 0; i < n; i++){
            int x = maxH[i];
            while(stack.size() > 1 && maxH[stack.peek()] >= x){
                int j = stack.pop();
                sum -= (long) maxH[j] * (j - stack.peek());
            }
            sum += (long) x * (i - stack.peek());
            ans = Math.max(ans, sum + suffix[i + 1]);
            stack.push(i);
        }

        return ans;
    }
}
// @lc code=end

