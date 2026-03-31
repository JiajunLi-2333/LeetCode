/*
 * @lc app=leetcode id=1801 lang=java
 *
 * [1801] Number of Orders in the Backlog
 */
import java.util.*;
// @lc code=start
class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        //? buyer heap: maxHeap; [price, amount]
        PriorityQueue<int[]> buyers = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));

        //? seller heap: minHeap [price, amount]
        PriorityQueue<int[]> sellers = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        
        for(int[] order : orders){
            int price = order[0], amount = order[1],type = order[2];
            //TODO buy order
            if(type == 0){
                while(!sellers.isEmpty() && sellers.peek()[0] <= price && amount > 0){
                    int[] top = sellers.poll();
                    int matched = Math.min(amount, top[1]);
                    amount -= matched;
                    top[1] -= matched;
                    if(top[1] > 0){
                        sellers.offer(top);
                    }
                }
                if(amount > 0){
                    buyers.offer(new int[]{price, amount});
                }
            }
            else{
                while(!buyers.isEmpty() && buyers.peek()[0] >= price && amount > 0){
                    int[] top = buyers.poll();
                    int matched = Math.min(amount, top[1]);
                    amount -= matched;
                    top[1] -= matched;
                    if(top[1] > 0){
                        buyers.offer(top);
                    }
                }
                if(amount > 0){
                    sellers.offer(new int[]{price, amount}); 
                }
            }
        }
        int MOD = 1_000_000_007;
        int ans = 0;
        while(!buyers.isEmpty()){
            ans = (ans + buyers.poll()[1]) % MOD;
        }
        while(!sellers.isEmpty()){
            ans = (ans + sellers.poll()[1]) % MOD;
        }
        return ans;

    }
}
// @lc code=end

