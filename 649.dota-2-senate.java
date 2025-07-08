/*
 * @lc app=leetcode id=649 lang=java
 *
 * [649] Dota2 Senate
 */
import java.util.*;
// @lc code=start
class Solution {
    public String predictPartyVictory(String senate) {
        //Use two queues to simulate the banning process
        


        Deque<Integer> radiant = new ArrayDeque<>();
        Deque<Integer> dire = new ArrayDeque<>();
        int n = senate.length();
        //Store index of each senator in their respective queues
        for(int i = 0; i < n; i++){
            if(senate.charAt(i) == 'R'){
                radiant.addLast(i);
            }else{
                dire.addLast(i);
            }
        }

        while(!radiant.isEmpty() && !dire.isEmpty()){
            int rTop = radiant.pollFirst();
            int dTop = dire.pollFirst();
            //The senator with bigger index gets to be baned for all rounds
            if(rTop < dTop){
                //radiant senator bans dire senator
                radiant.addLast(rTop + n);
            }else{
                //dire senator bans radiant senator
                dire.addLast(dTop + n);
            }
        }
        return radiant.isEmpty() ? "Dire":"Radiant";

    }
}
// @lc code=end

