/*
 * @lc app=leetcode id=1209 lang=java
 *
 * [1209] Remove All Adjacent Duplicates in String II
 */
/*
Clarify:


*/
// @lc code=start
class Solution {
    public String removeDuplicates(String s, int k) {
        //Just use a variable to hold the number of consecutively the same letters
        int same = 0;
        StringBuilder ans = new StringBuilder();
        for(char c : s.toCharArray()){
            ans.append(c);
            int len = ans.length();
            if(len > 1 && ans.charAt(len - 2) == c){
                same++;
            }
            else same = 1;

            if(same == k){
                ans.delete(len - k, len);
                same = 0;
                int lenDelete = ans.length();
                while(lenDelete > 1 && ans.charAt(lenDelete - 1) == ans.charAt(lenDelete -2) && same < k){
                    lenDelete--;
                    same++;
                }
                if (lenDelete > 0) {
                    same++;
                }
            }


        }
        return ans.toString();

    }
}
// @lc code=end

