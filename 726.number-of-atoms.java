/*
 * @lc app=leetcode id=726 lang=java
 *
 * [726] Number of Atoms
 */
import java.util.*;
// @lc code=start
class Solution {
    public String countOfAtoms(String formula) {
        Deque<Map<String, Integer>> stack = new ArrayDeque<>(); 
        Map<String, Integer> map = new HashMap<>();
        int i = 0, n = formula.length();

        while(i < n){
            char c = formula.charAt(i);
            if(c == '('){
                stack.push(map);
                map = new HashMap<>();
                i++;
            }
            else if(c == ')'){
                i++;
                int num = 0;
                while(i < n && Character.isDigit(formula.charAt(i))){
                    num = num * 10 + (formula.charAt(i) - '0');
                    i++;
                }

                if(num == 0) num =1;

                Map<String, Integer> outer = stack.pop(); 
                for(var entry : map.entrySet()){
                    outer.merge(entry.getKey(), entry.getValue() * num, Integer::sum);
                }
                map = outer;
            } 
            else{
                //read the element's name
                int start = i;
                i++;
                while(i < n && Character.isLowerCase(formula.charAt(i)))i++;
                String name = formula.substring(start, i);
                //read the number
                int num = 0; 
                while(i < n && Character.isDigit(formula.charAt(i))){
                    num = num * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                if(num == 0) num = 1;
                map.merge(name, num, Integer::sum);
            }
        }
        TreeMap<String, Integer> sorted = new TreeMap<>(map); 
        StringBuilder ans = new StringBuilder();
        for(var entry : sorted.entrySet()){
            ans.append(entry.getKey());
            if(entry.getValue() > 1) ans.append(entry.getValue());
        }
        return ans.toString();
    }
}
// @lc code=end

