/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 */
import java.util.*;
// @lc code=start
class Solution {
    //构建Letter Class 来方便计算流程
    private class Letter{
        char ch;
        int count;
        public Letter(int count, char ch){
            this.ch = ch;
            this.count = count;
        }
    }
    public String reorganizeString(String s) {
        
        //从valid的条件入手:
        //相邻的两个字母不能是一样的 => 数量最多的字母 是最有可能导致s不valid
        //每一步都优先考虑消耗数量最多的字母 => 完完全全的贪心策略
        
        
        //确定策略之后 通过题目特质开始构建算法细节
        //采取什么方式消耗数量最多的字母 => 最大堆确保每次都能拿到数量最多的字母

        StringBuilder ans = new StringBuilder();
        int[] counter = new int[26];
        

        //初始化最大堆：排序方式 = > 出现的次数
        PriorityQueue<Letter> pq = new PriorityQueue<>(
            new Comparator<Letter>() {
                @Override
                public int compare(Letter l1, Letter l2){
                    return l2.count - l1.count;
                }
            }
        );

        //统计每个字母在初始s中出现的次数
        for(int i = 0; i < s.length(); i++){
            counter[s.charAt(i) - 'a']++;
        }

        //遍历数组哈希表来记录出现次数
        for(int i = 0; i < 26; i++){
            

            //corner case => 如果有一个字母出现的次数超过了s长度的一半 那这个数组必不能实现重组
            if(counter[i] > (s.length() + 1)/2){
                return "";
            }
            //输入最大堆
            if(counter[i] > 0){
                pq.offer(new Letter(counter[i], (char)(i + 'a')));
            }
        }

        //构造新s
        while(!pq.isEmpty()){
            Letter cur = pq.poll();

            if (ans.length() > 0 && ans.charAt(ans.length() - 1) == cur.ch) {
                // 不能接 cur，需要用第二多的
                if (pq.isEmpty()) return ""; // 理论上不会发生（前面已判定可行），保险起见
                Letter next = pq.poll();
                ans.append(next.ch);
                next.count--;
                if (next.count > 0) pq.offer(next);
                // cur 还没用过，count 没变，放回
                pq.offer(cur);
            } else {
                // 可以接 cur
                ans.append(cur.ch);
                cur.count--;
                if (cur.count > 0) pq.offer(cur);
            }
        }
        return ans.toString();

    }
}
// @lc code=end

