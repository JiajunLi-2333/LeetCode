/*
 * @lc app=leetcode id=678 lang=java
 *
 * [678] Valid Parenthesis String
 */
import java.util.*;
/*
Clarify:
The question is very clear, see if the string are all matched () with the help of *.
Brutal:
initialize boolean[] to check whether a parenthesis or an * has been matched yet. iterate through the array, skip on *. if c == (, then we iterate to the right to see if we can find a matching ), if not, iterate again to see if we can find an * that does the work. Similarly for ). If all the element has been marked at the end, then we return true, otherwise it is a false.
Bottleneck: 
Obviously, we are just iterating over and over again. The slowest point is that we are finding the available match every time. So it may be a better idea to find a way to keep track of the available ones.
Keyword: Dynamically maintaining -> stack
Optimize:
use two stacks, one keep track of the ( and another keep track of *. And yet a even better solution will be to use just two variables to keep track of them

*/
// @lc code=start
class Solution {
    public boolean checkValidString(String s) {
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++; r++;
            } else if (c == ')') {
                l--; r--;
            } else {
                l--; r++;
            }
            l = Math.max(l, 0);
            if (l > r) return false;
        }
        return l == 0;
    //    Deque<Integer> right = new ArrayDeque<>();
    //    Deque<Integer> star = new ArrayDeque<>(); 

    //    char[] c = s.toCharArray();
    //    int n = c.length;
    //    for(int i = 0; i < n; i++){
    //         if(c[i] == '('){
    //             right.push(i);
    //         }
    //         if(c[i] == '*'){
    //             star.push(i);
    //         }
    //         if(c[i] == ')'){
    //             if(!right.isEmpty()){
    //                 right.pop();
    //             }else if(!star.isEmpty()){
    //                 star.pop();
    //             }
    //             else{
    //                 return false;
    //             }
    //         }
    //    }
    //    while(!right.isEmpty()){
    //         if(star.isEmpty()) return false;
    //         if(right.pop() > star.pop()) return false;
    //    }
    //    return true;

    
    }
}
// @lc code=end

