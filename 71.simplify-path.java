/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */
import java.util.ArrayList;
import java.util.List;
// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        //clarification
        //given string, we need to simplify it according to the following rules
        // . and .. need to be removed
        // "//" and "///" need to be removed 
        
        //constraints
        // 1 <= path.length <= 3000
        // path : English letters, digits, . / _
        // path is already a valid absolute Unix path -> /a/ss/...

        //cases
        //path: "///home" -> "/home"
        //path: "/home///" -> "/home"
        //path: "/home/.." -> "/"
        //path: "/../" -> "/"
        //path: "/home/user/picture/./../documents" -> "/home/user/documents"
        //path: "/"
        
        List<String> stack = new ArrayList<>();
        //after split, all / will be gone
        for(String s : path.split("/")){
            if(s.isEmpty() || s.equals("." )){
                continue;
            }
            if(!s.equals("..")){
                stack.add(s);
            }
            else if(!stack.isEmpty()){
                stack.remove(stack.size() - 1);
            }
        }
        return "/" + String.join("/",stack);
    }
}
// @lc code=end

