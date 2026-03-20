/*
 * @lc app=leetcode id=3170 lang=java
 *
 * [3170] Lexicographically Minimum String After Removing Stars
 */

// @lc code=start
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;
class Solution {
    public String clearStars(String s) {
        //clarification
        //string, goal is to remove the *
        //remove two things: leftmost * and smallest non * character on the left
        //If we delete from left to right, delete the * when we meet one and the smallest non * character
        
        //! we are trying to keep the result lexicographically smallest
        //we also want to delete the closest one
        //"a-----a----*" by induction proof method, the condition holds
        Deque<Integer>[] stacks = new ArrayDeque[26];
        Arrays.setAll(stacks, i -> new ArrayDeque<>());
        char[] cArray = s.toCharArray();
        for(int i = 0; i < cArray.length; i++){
            if(cArray[i] == '*'){
                for(int j = 0; j < 26; j++){
                    if(!stacks[j].isEmpty()){
                        stacks[j].pop();
                        break;
                    }
                }
            }
            else{
                stacks[cArray[i] - 'a'].push(i);
            }
        }
        char[] c = new char[cArray.length];
        for(int i = 0; i < stacks.length; i++){
            while(!stacks[i].isEmpty()){
                c[stacks[i].pop()] = (char) ('a' + i);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < c.length; i++){
            if(c[i] != 0){
                ans.append(c[i]);
            }
        }
        return ans.toString();
    }
}
// @lc code=end

