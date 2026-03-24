/*
 * @lc app=leetcode id=921 lang=java
 *
 * [921] Minimum Add to Make Parentheses Valid
 */
class Solution {
    public int minAddToMakeValid(String s) {
        // Deque<Character> stack = new ArrayDeque<>();
        // for(char c : s.toCharArray()){
        //     if(c == '('){
        //         stack.push(c);
        //     }else{
        //         if(!stack.isEmpty() && stack.peek() == '('){
        //             stack.pop();
        //         }
        //         else{
        //             stack.push(c);
        //         }
        //     }
        // }
        // return stack.size();
        int cnt = 0, ans = 0;
        for(char c : s.toCharArray()){
            cnt += c == '(' ? 1 : -1;
            if(cnt < 0){
                cnt = 0;
                ans++;
            }
        }
        return ans + cnt;


    }
}
// @lc code=end

