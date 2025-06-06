/*
 * @lc app=leetcode id=1003 lang=java
 *
 * [1003] Check If Word Is Valid After Substitutions
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int len = ans.length();
            char c = s.charAt(i);
            if(len >= 2 && ans.charAt(len - 2) == 'a' && ans.charAt(len - 1) == 'b' && c == 'c'){
                ans.deleteCharAt(len -1 );
                ans.deleteCharAt(len -2);
            }
            else
            {
                ans.append(c);
            }
        }
        return ans.isEmpty();
        
    }
}
// @lc code=end

