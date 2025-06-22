/*
 * @lc app=leetcode id=1111 lang=java
 *
 * [1111] Maximum Nesting Depth of Two Valid Parentheses Strings
 */

// @lc code=start
class Solution {
    public int[] maxDepthAfterSplit(String seq) {

        // seq is a valid parentheses string
        // depth(A,B) = max(depth(A), depth(B)) => depth(A) should be as closes to depth(B) as possible
        int[] ans = new int[seq.length()];
        int index = 0; // decide which string to put the current parenthesis in
        //index should also be named as string indicator, because it indicates which string we are currently filling
        for(int i = 0; i < seq.length();i++){
            char c = seq.charAt(i);
            if(c == '('){
                ans[i] = index % 2;
                index++; // the next ( will be put in the other string
            }
            else{
                ans[i] = (index - 1) % 2; // the next ) will be put in the same string as the last (
                index--; // we are closing a parenthesis, so we decrease the index
            }
        }
        return ans;
        
    }
}
// @lc code=end

