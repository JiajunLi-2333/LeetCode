/*
 * @lc app=leetcode id=1801 lang=java
 *
 * [1801] Number of Orders in the Backlog
 */
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    /**
     * @param orders
     * @return
     */
    public int getNumberOfBacklogOrders(int[][] orders) {
        //Buy order wants the sell price as low as possible
        //Sell order wants the buy price as high as possible

        //Buy backlogs should be a maxheap
        PriorityQueue<int[]> buyBacklog = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        //Sell backlogs should be a minheap
        PriorityQueue<int[]> sellBacklog = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int[] order : orders){
            int price = order[0];
            int amount = order[1];
            int type = order[2]; // 0 for buy 1 for sell

            if(type == 0){//Buy order
                if(sellBacklog.isEmpty() || sellBacklog.peek()[0] > price){
                    buyBacklog.offer(new int[]{price, amount});
                }
                else{
                    //Match with the sell order
                    while(amount > 0 && !sellBacklog.isEmpty() && sellBacklog.peek()[0] <= price){
                        int[] sellOrder = sellBacklog.poll();
                        int sellAmount = sellOrder[1];
                        if(sellAmount > amount){
                            sellOrder[1] -= amount;
                            sellBacklog.offer(sellOrder);
                            amount = 0;
                        }
                        else{
                            amount -= sellAmount;
                            if(amount == 0){
                                break;
                            }
                        }
                    }
                    //Add the remaining buy order to backlog
                    if(amount > 0){
                        buyBacklog.offer(new int[]{price, amount});
                    }

                }
            }
            else{//sell order
                if(buyBacklog.isEmpty() || buyBacklog.peek()[0] < price){
                    sellBacklog.offer(new int[]{price, amount});
                }
                else{
                    //Match with the buy order
                    while(amount > 0 && !buyBacklog.isEmpty() && buyBacklog.peek()[0] >= price){
                        int[] buyOrder = buyBacklog.poll();
                        int buyAmount = buyOrder[1];
                        if(buyAmount > amount){
                            buyOrder[1] -= amount;
                            buyBacklog.offer(buyOrder);
                            amount = 0;
                        }
                        else{
                            amount -= buyAmount;
                            if(amount == 0){
                                break;
                            }
                        }
                    }
                    //Add the remaining sell order to backlog
                    if(amount > 0){
                        sellBacklog.offer(new int[]{price, amount});
                    }
                }

            }

        }

        int MOD = 1000000007;
        long ans = 0;
        while(!buyBacklog.isEmpty()){
            int[] buyOrder = buyBacklog.poll();
            ans = (ans + buyOrder[1]) % MOD;  
        }
        while(!sellBacklog.isEmpty()){
            int[] sellOrder = sellBacklog.poll();
            ans = (ans + sellOrder[1]) % MOD;  
        }
        return (int)ans;
    }
}
// @lc code=end

