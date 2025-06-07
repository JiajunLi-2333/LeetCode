/*
 * @lc app=leetcode id=1021 lang=java
 *
 * [1021] Remove Outermost Parentheses
 */
// @lc code=start
class Solution {
    public String removeOuterParentheses(String s) {
        int left = 0, right = 0;
        StringBuilder ans = new StringBuilder();
        for(char c : s.toCharArray()){
            ans.append(c);
            if(c == '('){
                left++;
            }
            else right++;
            if(!ans.isEmpty() && left == right && left > 0 && right > 0){
                int primitiveLen = left + right;
                int startIndex = ans.length() - primitiveLen;
                ans.deleteCharAt(ans.length() -1);
                ans.deleteCharAt(startIndex);
                left = right = 0;
            }
            
        }
        return ans.toString();

    }
}
// @lc code=end

