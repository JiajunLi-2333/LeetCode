/*
 * @lc app=leetcode id=768 lang=java
 *
 * [768] Max Chunks To Make Sorted II
 */
import java.util.*;
/*

 */
// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {

        Deque<Integer> stack = new ArrayDeque<>();
        for(int num : arr){
            if(stack.isEmpty() || stack.peek() <= num){
                stack.push(num);
            }
            else{
                int max = stack.pop();
                while(!stack.isEmpty() && num < stack.peek()){
                    stack.pop();
                }
                stack.push(max);
            }
        }
        return stack.size();


        //TODO my own approach
        // int n = arr.length;
        // int[] sorted = arr.clone();
        // Arrays.sort(sorted);
        // int ans = 0;
        // Map<Integer, Integer> map = new HashMap<>();
        // int i = 0;
        // while(i < n){
        //     if(arr[i] == sorted[i]) {ans++; i++;}
        //     //此时arr[i] > sorted[i]
        //     else{
        //         //不断扩展匹配直到词频完全一致
        //         int j = i; 
        //         int nonZero = 0;
        //         while(j < n){
        //             int arrCount = map.merge(arr[j], 1, Integer::sum);
        //             if(arrCount == 0) nonZero--;
        //             else if(arrCount == 1 && map.getOrDefault(arr[j], 0) == 1) nonZero++;

        //             int sortedCount = map.merge(sorted[j], -1, Integer::sum);
        //             if(sortedCount == 0) nonZero--;
        //             else if(sortedCount == -1) nonZero++;
        //             j++;
        //             if(nonZero == 0) break;
        //         }
        //         ans++;
        //         i = j;
        //     }
        // }
        // return ans;
    }
}
// @lc code=end

