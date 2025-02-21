#
# @lc app=leetcode id=911 lang=python3
#
# [911] Online Election
#

# @lc code=start
from typing import List
from collections import defaultdict
import bisect 
class TopVotedCandidate:

    def __init__(self, persons: List[int], times: List[int]):
        cur_leader = -1 
        vote_count = defaultdict(int)
        self.times = times
        self.leader_history = []

        for i in range(len(times)):
            vote_count[persons[i]] += 1
            if cur_leader == -1 or vote_count[persons[i]] >= vote_count[cur_leader]:
                cur_leader = persons[i]
            self.leader_history.append(cur_leader)

    def q(self, t: int) -> int:
        return self.leader_history[bisect.bisect_right(self.times, t) - 1]
    


# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)
# @lc code=end

