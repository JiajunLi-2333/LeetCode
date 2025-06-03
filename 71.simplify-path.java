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

        //Build the result first and deal with the / in a later step
        String[] fileAndDirs = path.split("/");

        List<String> ans = new ArrayList<>();

        for(String fileOrDir : fileAndDirs){

            //Ignore the . and empty strings
            if(fileOrDir.equals("") || fileOrDir.equals(".")){
                continue;
            }
            else if(fileOrDir.equals("..")){
                //If we encounter a .., we need to remove the last element from the result
                if(!ans.isEmpty()){
                    ans.remove(ans.size() - 1);
                }else{
                    //If the result is empty, we can ignore the ..
                    continue;
                }
            }
            else{
                ans.add(fileOrDir);
            }
        }
        String res = "/";
        for(int i = 0; i < ans.size(); i++){
            res += ans.get(i);
            if(i != ans.size() - 1){
                res += "/";
            }
        }
        return res;

    }
}
// @lc code=end

