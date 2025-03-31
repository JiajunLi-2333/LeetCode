#
# @lc app=leetcode id=649 lang=python3
#
# [649] Dota2 Senate
#

# @lc code=start
from collections import deque
class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        # R , D = True, True
        # flag = 0

        # senate = list(senate)
        # while R and D: 
        #     R = False
        #     D = False
        #     for i in range(len(senate)) :
        #         if senate[i] == 'R' :
        #             if flag < 0: senate[i] = '0'
        #             else: R = True
        #             flag += 1
        #         if senate[i] == 'D':
        #             if flag > 0: senate[i] = '0'
        #             else: D = True
        #             flag -= 1
        # return "Radiant" if R else "Dire"
        Radiant = deque()
        Dire = deque()
        for i,c in enumerate(senate):
            if c == 'R':
                Radiant.append(i)
            else:
                Dire.append(i)
        while Radiant and Dire:
            r, d = Radiant.popleft(), Dire.popleft()
            if r < d:
                #This simulates the next round of the game
                Radiant.append(r + len(senate))
            else:
                Dire.append(d + len(senate))
        return "Radiant" if Radiant else "Dire" 
# @lc code=end

