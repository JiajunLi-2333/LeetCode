/*
 * @lc app=leetcode id=853 lang=java
 *
 * [853] Car Fleet
 */

// @lc code=start
class Solution {
	public int carFleet(int target, int[] position, int[] speed) {
		int len = position.length;
		int[][] infos = new int[len][2];
		for (int i = 0; i < len; i++) {
			infos[i][0] = position[i];
			infos[i][1] = speed[i];
		}
		Arrays.sort(infos, (a, b) -> b[0] - a[0]);
		double arrival = Integer.MIN_VALUE;
		int ans = 0;
		for (int i = 0; i < len; i++) {
			int[] info = infos[i];
			double cur = (double)(target - info[0]) / info[1];
			if (cur > arrival) {
				ans += 1;
				arrival = cur;
			}
		}
		return ans;
	}
}
// @lc code=end

