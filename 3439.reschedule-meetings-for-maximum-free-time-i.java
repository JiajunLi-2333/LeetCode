/*
 * @lc app=leetcode id=3439 lang=java
 *
 * [3439] Reschedule Meetings for Maximum Free Time I
 */

// @lc code=start
class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        //! use sliding window to validate every possible k meetings and reduce repeated calculation --> window slide in and out the time gap between meetings
        //Still a sliding window problem
        int result = 0;
        int sum = 0;
        for(int i = 0; i <= startTime.length; i++){ // i could be equal to the startTime.length to get the free time after the last meeting
            sum += get(i, eventTime, startTime, endTime);
            if(i >= k){
                result= Math.max(result, sum);
                sum -= get(i - k, eventTime, startTime, endTime);//! exists the window
            }
        }
        return result;
    }
    private int get(int i, int eventTime, int[] startTime, int[] endTime){
            if(i == 0){
                return startTime[0];
            }
            int n = startTime.length;
            if(n == i){
                return eventTime - endTime[n - 1];
            }
            return startTime[i] - endTime[i -1];//! time gap between the last meeting and the current meeting
        }
}
// @lc code=end

