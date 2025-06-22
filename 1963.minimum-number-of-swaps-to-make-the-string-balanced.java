/*
 * @lc app=leetcode id=1963 lang=java
 *
 * [1963] Minimum Number of Swaps to Make the String Balanced
 */

// @lc code=start
class Solution {
    public int minSwaps(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        int balance = 0;
        int j = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if(chars[i] == '['){
                balance++;
            }
            else if(balance > 0){
                balance--;
            }
            else{ //balance == 0
                while(j > 0 && chars[j] == ']'){
                    j--;
                }
                chars[j] = ']';
                ans++;
                balance++;
            }
                
        }
        return ans;
    }
}
// @lc code=end

