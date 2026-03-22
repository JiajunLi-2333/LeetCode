/*
 * @lc app=leetcode id=1541 lang=java
 *
 * [1541] Minimum Insertions to Balance a Parentheses String
 */


/*
Clarify:
Now ( + )) is a balanced pair. Given string s, we need to find the minimum number of insertions needed. 
?:
The initiative is that insertion only happens to those who are unmatched. And the optimal solution is how do you plan the insertion. e.g: () can be inserted as ()) or ()) ()). And the greedy is to inserted based on what's left. So we can use stack to eliminate all the matching ones (both independent and nested matches). What is left in the stack are the ones need to be inserted.
Keyword:Greedy + Stack 

*/
// @lc code=start
class Solution {
    public int minInsertions(String s) {
       int ans = 0;
       int right = 0;
       for(char c : s.toCharArray()){
            if(c == '('){
                right += 2;
                if(right % 2 == 1){
                    ans++;
                    right--;
                }
            }
            if(c == ')'){
                right--;
                if(right == -1){
                    ans++;
                    right = 1; 
                }
            }
       }
       return ans + right;
    }
}
// @lc code=end

