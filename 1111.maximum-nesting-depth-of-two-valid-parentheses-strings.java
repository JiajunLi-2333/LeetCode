/*
 * @lc app=leetcode id=1111 lang=java
 *
 * [1111] Maximum Nesting Depth of Two Valid Parentheses Strings
 */
/*
Clarify:
The given string itself is a VPS with Depth d, and the job is to divide it 
into two separate VPS X and Y with depth x and depth y. 
There are different ways to divide, the goal is to find min(max(x, y)).
Key constraint: every character must go to either X or Y, and both must be valid VPS.

Brutal:
Each character has 2 choices: go to X or go to Y. 
Enumerate all 2^n assignments, check if both X and Y are valid VPS, 
then take min(max(depth(X), depth(Y))). 
TC: O(2^n * n), way too slow.

Bottleneck:
Type E (搜索空间太大): 2^n assignments, but most are invalid. 
The constraint is that matched pairs must go to the same group 
(otherwise the VPS structure breaks). 
So the real unit of assignment is not individual characters, 
but matched pairs at each depth level.

Key Observation:
Each character sits at a specific depth level in the original string. 
A matched pair (same depth) must be assigned to the same group. 
So the question simplifies to: assign each DEPTH LEVEL to either X or Y, 
minimize max(x, y).

Optimize (Greedy):
Since we are minimizing max(x, y), we want x and y as close as possible.
The original max depth is d, and each level must go entirely to X or Y.
Best strategy: split levels evenly → odd levels to X, even levels to Y.
Result: both X and Y have depth ⌈d/2⌉.

Why greedy works (swap argument):
If any other assignment gives a better result, it must have max < ⌈d/2⌉.
But there are d levels total, and each must go to one side.
By pigeonhole, one side must take at least ⌈d/2⌉ levels. 
So ⌈d/2⌉ is a lower bound, and our strategy achieves it → optimal.

Implementation:
Track current depth with a counter (no actual stack needed since we only 
need depth, not per-layer context).
Assign each character based on depth % 2.
TC: O(n), SC: O(1) (excluding output array). 

*/
// @lc code=start
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        
        char[] c = seq.toCharArray();

        int depth = 0; 
        for(int i = 0; i < n; i++){
            if(c[i] == '('){
                depth++;
                ans[i] = depth % 2;
            }else{
                ans[i] = depth % 2;
                depth--;
            }
        }
        return ans;
        
    }
}
// @lc code=end

