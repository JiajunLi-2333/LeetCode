/*
 * @lc app=leetcode id=1541 lang=java
 *
 * [1541] Minimum Insertions to Balance a Parentheses String
 */

// @lc code=start
class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int len = s.length();
        int left = 0; //count completely unmatched left parentheses
        
        //! 重点在补齐 右括号之后直接消除一个左括号 如果没有左括号 那就意味着需要补一个左括号
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(c == '('){
                left++;
            }
            else{
                if(i + 1 < len && s.charAt(i  + 1) == ')'){
                    i++;
                }
                else{
                    ans++;
                }
                if(left  > 0){
                    left--;
                }
                else{
                    ans++;
                }
            }
        
        }
        return ans + left * 2;      
    }
}
// @lc code=end

