/*
 * @lc app=leetcode id=844 lang=java
 *
 * [844] Backspace String Compare
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String s, String t) {
        // time complexity: O(n + m)
        // StringBuilder sb1 = new StringBuilder();
        // StringBuilder sb2 = new StringBuilder();
        // for(char c : s.toCharArray()) {
        //     if(c == '#'){
        //         if(sb1.length() > 0){
        //             sb1.deleteCharAt(sb1.length() - 1);
        //         }else{
        //             continue;
        //         }
        //     }else{
        //         sb1.append(c);
        //     }
        // }
        // for(char c : t.toCharArray()) {
        //     if(c == '#'){
        //         if(sb2.length() > 0){
        //             sb2.deleteCharAt(sb2.length() - 1);
        //         }else{
        //             continue;
        //         }
        //     }else{
        //         sb2.append(c);
        //     }
        // }
        // return sb1.toString().equals(sb2.toString());
        // int n = s.length(), m = t.length();
        // int left = n - 1, right = m - 1;
        // int skipS = 0, skipT = 0;
        // while (left >= 0 || right >= 0) {
        //     while (left >= 0) {
        //         if (s.charAt(left) == '#') {
        //             skipS++;
        //             left--;
        //         } else if (skipS > 0) {
        //             skipS--;
        //             left--;
        //         } else {
        //             break;

        //         }
        //     }
        //     while (right >= 0) {
        //         if (t.charAt(right) == '#') {
        //             skipT++;
        //             right--;
        //         } else if (skipT > 0) {
        //             skipT--;
        //             right--;
        //         } else {
        //             break;
        //         }
        //     }
        //     if (left >= 0 && right >= 0 && s.charAt(left) != t.charAt(right)) {
        //         return false;
        //     }
        //     left--;
        //     right--;
        // }
        // return left == right;
        int n = s.length(), m = t.length();
        int i = n - 1, j = m - 1;
        while(i > 0 && j > 0){
            while(i > 0 && s.charAt(i) == '#'){
                i -= 2;
            }
            while(j > 0 && t.charAt(j) == '#'){
                j -= 2;
            }
            if(i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)){
                return false;
            }
            i--;
            j--;
        }
        return i == j;

    }
}
// @lc code=end

