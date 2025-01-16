#
# @lc app=leetcode id=2379 lang=python3
#
# [2379] Minimum Recolors to Get K Consecutive Black Blocks
#

# @lc code=start
class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        change = 0
        change_record = []
        for i, c  in enumerate(blocks):
            #Enter the window
            if c == "W":
                change += 1
            if i < k - 1:
                continue
            change_record.append(change)
            #Exit the window
            if blocks[i - k + 1] == "W":
                change -= 1   
        return min(change_record) if change_record else 0    
# @lc code=end

