/*
 * @lc app=leetcode id=2904 lang=java
 *
 * [2904] Shortest and Lexicographically Smallest Beautiful String
 */

// @lc code=start
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        //滑动窗口 更新答案的技巧的方式上有点难度
        // 题目条件没有探索干净： 最短字母序最小 -> 长度优先级 + 字母序优先级
        if(s.replace("0","").length() < k) return "";
        char[] chars = s.toCharArray();
        int left = 0; 
        String ans = "";
        int count = 0; 
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '1') count++;
            while(count > k || chars[left] == '0'){// 这里需要注意的是，左指针可能会指向0
                if(chars[left++] == '1') count--;
            }
            if(count == k){
                String res = s.substring(left, i + 1);
                if(ans.isEmpty() || res.length() < ans.length() || (res.length() == ans.length() && res.compareTo(ans) < 0)){
                    ans = res;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

