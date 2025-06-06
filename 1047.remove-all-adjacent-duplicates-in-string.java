

/*
 * @lc app=leetcode id=1047 lang=java
 *
 * [1047] Remove All Adjacent Duplicates In String
 */
// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty() && stack.charAt(stack.length() -1) == s.charAt(i)){
                stack.deleteCharAt(stack.length() - 1);
            }
            else{
                stack.append(s.charAt(i));
            }
        }
        return stack.toString();

        
    }
}
// @lc code=end

