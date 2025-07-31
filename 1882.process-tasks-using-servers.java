/*
 * @lc app=leetcode id=1882 lang=java
 *
 * [1882] Process Tasks Using Servers
 */
import java.util.PriorityQueue;
// @lc code=start
class Solution {
    //? create the server class for convenience
    class Server {
        private int index;
        private int weight;
        private int time;

        public Server(int index, int weight, int time){
            this.index = index;
            this.weight = weight;
            this.time = time;//time when the server will be free
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        //TODO Initialize two priority queues
        // One for idle servers (min-heap by weight, then by index)
        // One for busy servers (min-heap by time, then by index)
        PriorityQueue<Server> idle = new PriorityQueue<>((a, b) -> {
            return a.weight != b.weight ? Integer.compare(a.weight, b.weight) : Integer.compare(a.index, b.index);
        });
        PriorityQueue<Server> busy = new PriorityQueue<>((a, b) -> {
            return a.time != b.time ? Integer.compare(a.time, b.time) : Integer.compare(a.index, b.index);
        });

        for(int i = 0; i < servers.length; i++){
            idle.offer(new Server(i, servers[i], 0)); // Initially all servers are idle
        }

        int[] ans = new int[tasks.length];
        int index = 0;
        int curTime = -1; //time tracker
        while(index < tasks.length){
            //check the busy servers and update the current time
            while(true){
                curTime++;
                while(!busy.isEmpty() && busy.peek().time <= curTime){
                    Server freeServer = busy.poll();
                    idle.offer(freeServer); // Move the server back to idle
                }
                if(!idle.isEmpty()){
                    break;
                }
                else{
                    curTime = busy.peek().time -1; // Update current time to the next available server's time
                }
            }



            //if server available, assign the task
            while(!idle.isEmpty() && index <= curTime && index < tasks.length){
                Server target = idle.poll();
                target.time = curTime + tasks[index]; // Update the time when the server will be free
                ans[index] = target.index;
                busy.offer(target);
                index++;
            }

           
        }
        return ans;
    }
}





// @lc code=end
