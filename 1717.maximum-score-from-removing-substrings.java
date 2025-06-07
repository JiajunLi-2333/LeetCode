/*
 * @lc app=leetcode id=1717 lang=java
 *
 * [1717] Maximum Score From Removing Substrings
 */

// @lc code=start
class Solution {
    public int maximumGain(String s, int x, int y) {
        // s = cdbcbbaaabab
        // s = cdbcbbaaab ans += 4
        // s = cdbcbbaa   ans += 4
        // s = cdbcba     ans += 5
        // s = cdbc       ans += 5 ans = 18
        // Correct pattern
        // s = cdbcbbaaabab
        // s = cdbcbbaaab ans += 5
        // s = cdbcbbaa   ans += 4
        // s = cdbcba     ans += 5
        // s = cdbc       ans += 5 ans = 19
        // The point here is that we should prioritize the one with the larger score
        // s = aabbaaxybbaabb, x = 5, y = 4 remove as many ab as possible
        // aaxybb 4 * 5 ans = 20

        //todo ugly but works
        int ans = 0;
        StringBuilder sb_one = new StringBuilder();
        StringBuilder sb_two = new StringBuilder();
        if (x > y){
            for (char c : s.toCharArray()){
                int len = sb_one.length();
                if(!sb_one.isEmpty() && c == 'b' && sb_one.charAt(len - 1) == 'a'){
                    ans += x;
                    sb_one.deleteCharAt(len -1);
                }else sb_one.append(c);
            }
            for(char c: sb_one.toString().toCharArray()){
                int len = sb_two.length();
                if(!sb_two.isEmpty() && c == 'a' && sb_two.charAt(len - 1) == 'b'){
                    ans += y;
                    sb_two.deleteCharAt(len -1);
                }else sb_two.append(c);
            }

        }else{
            for (char c : s.toCharArray()){
                int len = sb_one.length();
                if(!sb_one.isEmpty() && c == 'a' && sb_one.charAt(len - 1) == 'b'){
                    ans += y;
                    sb_one.deleteCharAt(len -1);
                }else sb_one.append(c);
            }
            for(char c: sb_one.toString().toCharArray()){
                int len = sb_two.length();
                if(!sb_two.isEmpty() && c == 'b' && sb_two.charAt(len - 1) == 'a'){
                    ans += x;
                    sb_two.deleteCharAt(len -1);
                }else sb_two.append(c);
            }
        }
        return ans;
    }
}
// @lc code=end

