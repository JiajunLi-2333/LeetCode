/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) { 
        HashMap<String, Integer> wordsCount = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        //Find the number of words and the occurrence of each word
        for(String word: words){
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
        }

        int elementLen = words[0].length(); // length of each element in the word array
        int winSize = words.length * elementLen;// using the window size
        int n = s.length();

        for(int i = 0; i < elementLen; i++){

            HashMap<String, Integer> temp = new HashMap<>();
            int left = i;
            for(int j = i; j + elementLen <= n; j += elementLen){
                String cur = s.substring(j, j + elementLen);
                //if the current substring is not in the words array, we can skip it for a faster process
                if (!wordsCount.containsKey(cur)){
                    temp.clear();
                    left = j + elementLen;
                    continue;
                }
                //add the current substring to the temp map
                temp.put(cur, temp.getOrDefault(cur, 0) + 1);
                
                //check the lengh between i and j 
                if(j - left + elementLen == winSize){
                    //if the length is equal to the window size, we can check if the temp map is equal to the wordsCount map
                    if(temp.equals(wordsCount)) res.add(left);
                    //remove the leftmost element from the temp map
                    String leftWord = s.substring(left, left + elementLen);
                    temp.put(leftWord, temp.get(leftWord) - 1);
                    if(temp.get(leftWord) == 0){
                        temp.remove(leftWord);
                    }
                    left += elementLen;
    
                }
            }

        }
        return res;
    }
}
// @lc code=end

