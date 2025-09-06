/*
 * @lc app=leetcode id=1616 lang=java
 *
 * [1616] Split Two Strings to Make Palindrome
 */

// @lc code=start
class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        // for(int i = 0; i < a.length(); i++){
        //     String s1 = a.substring(0, i) + b.substring(i);
        //     String s2 = b.substring(0, i) + a.substring(i);
        //     if(check(s1) || check(s2)){
        //         return true;
        //     }
        // }
        // return false;
        return check(a, b) || check(b, a);
    }

    //use two pointers to check if s1 + s2 or s2 + s1 can form a palindrome
    // private boolean check(String s){
    //     int left = 0, right = s.length() - 1;
    //     while(left < right){
    //         if(s.charAt(left) != s.charAt(right)){
    //             return false;
    //         }
    //         left++;
    //         right--;
    //     }
    //     return true;
    // }
    private boolean check(String a, String b){
        int left = 0, right = a.length() - 1;
        while(left < right && a.charAt(left) == b.charAt(right)){
            left++;
            right--;
        }
        return isPalindrome(a, left, right) || isPalindrome(b, left, right);
    }
    private boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
// @lc code=end

