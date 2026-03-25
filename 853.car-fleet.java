/*
 * @lc app=leetcode id=853 lang=java
 *
 * [853] Car Fleet
 */
import java.util.*;
// @lc code=start
class Solution {
	public int carFleet(int target, int[] position, int[] speed) {
		if(position.length == 1) return 1; 
		int ans = 0;
		Deque<int[]> stack = new ArrayDeque<>();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < position.length; i++){
			map.put(position[i], speed[i]);
		}
		Arrays.sort(position);
		for(int i = position.length - 1 ; i >= 0; i--){
			int currSpeed = map.get(position[i]);
			double currTime = (double)(target - position[i]) / currSpeed;

			if(stack.isEmpty()){
				stack.push(new int[]{currSpeed, position[i]});
				ans++;
				continue;
			}

			int topSpeed = stack.peek()[0];
			int topPos   = stack.peek()[1];
			double topTime = (double)(target - topPos) / topSpeed;

			if(currTime > topTime){
				// 追不上前方车队，自成一队
				stack.push(new int[]{currSpeed, position[i]});
				ans++;
			}
			// 否则追得上，合并进前方车队，不入栈
		}
		return ans;
	}
}
// @lc code=end

