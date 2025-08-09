/*
 * @lc app=leetcode id=1953 lang=java
 *
 * [1953] Maximum Number of Weeks for Which You Can Work
 */

// @lc code=start
class Solution {
    public long numberOfWeeks(int[] milestones) {
        //本质策略不改变：假设最终组成的数组为s，任务阶段最多的任务被消耗的越多，符合条件的s长度越长 => 贪心
        //题目的分析思路： 
        //数组s的长度为大为多少 => milestone的和
        //当数组中出现最多的任务阶段为多少时，s的长度 < milestone的和?
        //当s < milestone的时候，s的长度最大能到多少？

        //所有的分析都基于这里的贪心策略：解决阶段最多的任务
        long s = 0;
        int m = 0;
        for(int x : milestones){
            s += x;
            m = Math.max(m, x);
        }
        return m > s-m + 1 ? (s - m) * 2  + 1 : s;

        //如果使用最大堆 => 在数据够大的情况下会直接出现TLE或者MLE的情况


    }
}
// @lc code=end

