/*
 * @lc app=leetcode id=3296 lang=java
 *
 * [3296] Minimum Number of Seconds to Make Mountain Height Zero
 */
class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        //! [自己做完下一个单位后的总用时，workerTime[i], 已经消除的高度]
        // PriorityQueue<long[]> minHeap = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        // long ans = 0;
        // for(int time : workerTimes){
        //     long[] input = new long[]{time, time, 1};
        //     minHeap.offer(input);
        // }
        // while(mountainHeight > 0){
        //     long[] top = minHeap.poll();
        //     ans = Math.max(ans, top[0]);
        //     top[2]++; top[0] += (top[2] * top[1]);
        //     minHeap.offer(top);
        //     mountainHeight--; 
        // }
        // return ans;
        int maxT = 0;
        for(int time : workerTimes){
            maxT = Math.max(maxT, time);
        }
        int h = (mountainHeight - 1) / workerTimes.length + 1;
        long left = 0;
        long right = (long) maxT * h *(h + 1) / 2;
        while(left + 1 < right){
            long mid = (left + right) / 2;
            if(check(mid, mountainHeight, workerTimes)){
                right = mid;
            }
            else{
                left = mid;
            }

        }
        return right; 
    }
    private boolean check(long m, int leftH, int[] workerTimes){
        for(int t : workerTimes){
            leftH -= ((int) Math.sqrt(m / t  * 8  + 1) - 1) / 2;
            if(leftH <= 0){
                return true;
            }   
        }
        return false;
    }

}
// @lc code=end

