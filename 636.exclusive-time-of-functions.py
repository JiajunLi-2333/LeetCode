#
# @lc app=leetcode id=636 lang=python3
#
# [636] Exclusive Time of Functions
#

# @lc code=start
from typing import List
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        #it really looks like a peeling onion problem
        def parse(log: str):
            idx, state, timestamp = log.split(':')
            return int(idx), state, int(timestamp)
        
        stack, ans, total = [], [0] * n, 0
        for log in logs:
            idx, state, timestamp = parse(log)
            if state == 'start':
                #push the tuple to the stack
                stack.append((idx, timestamp, total))
            else:
                idx_, timestamp_, total_ = stack.pop()
                diff = timestamp - timestamp_ + 1 - total + total_
                ans[idx] += diff
                total += diff
        return ans
# @lc code=end

