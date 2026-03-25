/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */
/*
Clarify:
The question asks what is the mininum number of ( or ) to remove. If we think about under what condition a parenthesis should be removed, it is going to be painful: the numbers have to match and the position needs to be correct. So we think about how to keep valid parenthesis as many as possible. That is to keep all that form pairs.
Brutal:
we can scan the string first to find out how many ) we have and iterate through the string. This is the counting way. See details
Optimize:
well, not really an upgrade but if we are finding parentheses that match, might consider stack. stack represent the parenthesis on the left of the string while we iterate to right
Keyword: Adjacent removal + matching -> stack
*/
// @lc code=start
class Solution {
    public String minRemoveToMakeValid(String s) {
        //Optimize: the nature of VPS states two conditions: number and position match, we can use just two variables to determine whether a ) has a match on its left.
        StringBuilder ans = new StringBuilder();
        int right = 0, left = 0; 
        for(char c : s.toCharArray()){
            if(c == ')')right++;
        }
    
        for(char c :s.toCharArray()){
            if(c == '('){
                if(right > 0){
                    right--;
                    left++;
                    ans.append(c);
                }
            }else if(c == ')'){
    
                if(left > 0){
                    left--; 
                    ans.append(c);
                }else{
                    right--;
                }
            }else{
                ans.append(c);
            }
        }
        return ans.toString();

        // Deque<Integer> stack = new ArrayDeque<>();
        // boolean[] preserve = new boolean[s.length()];
        // Arrays.fill(preserve, false);
        // for(int i = 0; i < s.length(); i++){
        //     if(s.charAt(i) == '('){
        //         stack.push(i);
        //     }else if(s.charAt(i) == ')'){
        //         if(!stack.isEmpty() && s.charAt(stack.peek()) == '(' ){
        //             int index = stack.pop();
        //             preserve[index] = true;
        //             preserve[i] = true;
        //         }
        //     }else{
        //         preserve[i] = true;
        //     }
        // }
        // StringBuilder ans = new StringBuilder();
        // for(int i = 0; i < s.length(); i++){
        //     if(preserve[i]){
        //         ans.append(s.charAt(i));
        //     }
        // }
        // return ans.toString();

    }
}
// @lc code=end

